package com.lifeplusbd.lifeplusbd.data

import com.lifeplusbd.lifeplusbd.data.local.UserDao
import com.lifeplusbd.lifeplusbd.model.MovieDesc
import com.lifeplusbd.lifeplusbd.model.Result
import com.lifeplusbd.lifeplusbd.model.TrendingMovieResponse
import com.lifeplusbd.lifeplusbd.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
){
    suspend fun getUserByNameAndPassword(name: String, password: String) : User{
        val result = userDao.getUserByUserNameAndPassword(name, password)
        return result!!
    }

    suspend fun createUser(user: User){
        userDao.insert(user)
    }
}