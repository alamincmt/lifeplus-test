package com.example.lifeplus_test.data

import com.example.lifeplus_test.data.local.MovieDao
import com.example.lifeplus_test.data.remote.MovieRemoteDataSource
import com.example.lifeplus_test.model.MovieDesc
import com.example.lifeplus_test.model.Result
import com.example.lifeplus_test.model.TrendingMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.single
import javax.inject.Inject

/**
 * Repository which fetches data from Remote or Local data sources
 */
class MovieRepository @Inject constructor(
        private val movieRemoteDataSource: MovieRemoteDataSource,
        private val movieDao: MovieDao
) {

    suspend fun fetchTrendingMovies(): Flow<Result<TrendingMovieResponse>?> {
        return flow {
            emit(fetchTrendingMoviesCached())
            emit(Result.loading())
            val result = movieRemoteDataSource.fetchTrendingMovies()

            //Cache to database if response is successful
            if (result.status == Result.Status.SUCCESS) {
                result.data?.results?.let { it ->
                    movieDao.deleteAll(it)
                    movieDao.insertAll(it)
                }
            }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    private fun fetchTrendingMoviesCached(): Result<TrendingMovieResponse>? =
            movieDao.getAll()?.let {
                Result.success(TrendingMovieResponse(it))
            }

    suspend fun fetchMovie(id: Int): Flow<Result<MovieDesc>> {
        return flow {
            emit(Result.loading())
            emit(movieRemoteDataSource.fetchMovie(id))
        }.flowOn(Dispatchers.IO)
    }
}