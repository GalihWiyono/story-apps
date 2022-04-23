package com.example.storyapp.viewmodel

import androidx.lifecycle.*
import com.example.storyapp.helper.wrapEspressoIdleResource
import com.example.storyapp.model.*
import com.example.storyapp.model.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val preference: UserPreference
) : ViewModel() {

    val isLoading: LiveData<Boolean> = userRepository.loading
    val userStatus: LiveData<Boolean> = userRepository.userStatus
    val loginResult: LiveData<LoginResult> = userRepository.loginData

    fun userLogin(loginUser: LoginUser) {
        userRepository.userLogin(loginUser)
    }

    fun userRegister(registerUser: RegisterUser) {
        userRepository.userRegister(registerUser)
    }

    fun saveUserPreference(loginResult: LoginResult) {
        viewModelScope.launch {
            preference.saveUserData(loginResult)
        }

    }

    fun getUserPreferences(): LiveData<LoginResult> {
        return preference.getUserData().asLiveData()
    }

    fun clearUserPreference() {
        viewModelScope.launch {
            preference.clearUserData()
        }
    }
}