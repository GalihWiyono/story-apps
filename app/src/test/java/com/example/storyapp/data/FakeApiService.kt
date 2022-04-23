package com.example.storyapp.data

import com.example.storyapp.helper.DataDummy
import com.example.storyapp.model.*
import com.example.storyapp.model.service.ApiService
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response

//class FakeApiService : ApiService {
//
//    private val dataDummy = DataDummy
//
//    override fun loginUser(loginUser: LoginUser): Call<LoginResponse> {
//        return dataDummy.generateLoginResponse()
//    }
//
//    override fun registerUser(registerUser: RegisterUser): Call<RegisterResponse> {
//        TODO("Not yet implemented")
//    }
//
//    override fun uploadStory(
//        auth: String,
//        file: MultipartBody.Part,
//        description: RequestBody
//    ): Call<StoryResponse> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun getAllStoriesPaging(
//        auth: String,
//        page: Int,
//        size: Int
//    ): Response<StoriesResponse> {
//        TODO("Not yet implemented")
//    }
//
//    override fun getAllStoriesLocation(auth: String, loc: Int): Call<StoryResponseWithLoc> {
//        TODO("Not yet implemented")
//    }
//}