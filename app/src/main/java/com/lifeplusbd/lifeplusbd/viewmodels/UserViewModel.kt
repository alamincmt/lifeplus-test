package com.lifeplusbd.lifeplusbd.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifeplusbd.lifeplusbd.data.UserRepository
import com.lifeplusbd.lifeplusbd.model.User
import kotlinx.coroutines.*
import javax.inject.Named

/**
 * ViewModel for User
 */
class UserViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository,
    @Named("userName") userName: String,
    @Named("password") password: String
    ) : ViewModel() {

    private lateinit var user : User

    init {
        findUser(userName, password)
    }

    private fun findUser(userName: String, password: String) {
        viewModelScope.launch {
            user = userRepository.getUserByNameAndPassword(userName, password)
        }
    }

    private suspend fun createUser(user : User){
        userRepository.createUser(user)
    }
}