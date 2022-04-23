package com.example.storyapp.model.service

import com.example.storyapp.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("login")
    fun loginUser(
        @Body loginUser: LoginUser
    ): Call<LoginResponse>

    @POST("register")
    fun registerUser(
        @Body registerUser: RegisterUser
    ): Call<RegisterResponse>

    @Multipart
    @POST("stories")
    fun uploadStory(
        @Header("Authorization") auth: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): Call<StoryResponse>

    @GET("stories")
    suspend fun getAllStoriesPaging(
        @Header("Authorization") auth: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<StoriesResponse>

    @GET("stories")
    fun getAllStoriesLocation(
        @Header("Authorization") auth: String,
        @Query("location") loc : Int = 1
    ): Call<StoryResponseWithLoc>
}