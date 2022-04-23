package com.example.storyapp.model.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.storyapp.helper.wrapEspressoIdleResource
import com.example.storyapp.model.*
import com.example.storyapp.model.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService,
) {
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _userStatus = MutableLiveData<Boolean>()
    val userStatus: LiveData<Boolean> = _userStatus

    private val _loginData = MutableLiveData<LoginResult>()
    val loginData: LiveData<LoginResult> = _loginData

    fun userLogin(loginUser: LoginUser) {
        _loading.value = true
        val client = apiService.loginUser(loginUser)
        client.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                _loading.value = false
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    _userStatus.value = true
                    Log.d("ResponseApi", "onResponse: ${responseBody.loginResult}")
                    _loginData.value = responseBody.loginResult
                } else {
                    _userStatus.value = false
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _loading.value = false
                Log.e("ResponseError", "onFailure: ${t.message}")
            }
        })
    }

    fun userRegister(registerUser: RegisterUser) {
        _loading.value = true
        val client = apiService.registerUser(registerUser)
        client.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                _loading.value = false
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    _userStatus.value = true
                    if (!responseBody.error) {
                        userLogin(LoginUser(registerUser.email, registerUser.password))
                    }
                    Log.d("ResponseAPI", "onResponse: ${responseBody.message}")
                } else {
                    _userStatus.value = false
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                _loading.value = false
                Log.d("ResponseAPI", "onFailure: ${t.message}")
            }

        })
    }

}