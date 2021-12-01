package com.lifeplusbd.lifeplusbd.network.services

import com.lifeplusbd.lifeplusbd.model.TrendingMovieResponse
import com.lifeplusbd.lifeplusbd.model.MovieDesc
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit API Service
 */
interface MovieService {

    @GET("/3/trending/movie/week")
    suspend fun getPopularMovies() : Response<TrendingMovieResponse>

    @GET("/3/movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int) : Response<MovieDesc>
}