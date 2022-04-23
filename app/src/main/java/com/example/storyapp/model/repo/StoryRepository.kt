package com.example.storyapp.model.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.storyapp.helper.wrapEspressoIdleResource
import com.example.storyapp.model.*
import com.example.storyapp.model.data.StoryPagingSource
import com.example.storyapp.model.service.ApiService
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class StoryRepository @Inject constructor(
    private val apiService: ApiService,
    private val storyPagingSource: StoryPagingSource
) {

    private val _storyWithLocation = MutableLiveData<List<ListStoryWithLoc>>()
    val storyWithLocation: LiveData<List<ListStoryWithLoc>> = _storyWithLocation

    private val _responseUpload = MutableLiveData<StoryResponse>()
    val responseUpload: LiveData<StoryResponse> = _responseUpload

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getStoriesPaging(): LiveData<PagingData<ListStoryItem>> {
        wrapEspressoIdleResource {
            return Pager(
                config = PagingConfig(
                    pageSize = 5
                ),
                pagingSourceFactory = {
                    storyPagingSource
                }
            ).liveData
        }
    }

    fun getStoriesWithLocation(token: String) {
        val client = apiService.getAllStoriesLocation("Bearer $token")
        client.enqueue(object : Callback<StoryResponseWithLoc> {
            override fun onResponse(
                call: Call<StoryResponseWithLoc>,
                response: Response<StoryResponseWithLoc>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    _storyWithLocation.value = responseBody.listStory
                }
            }

            override fun onFailure(call: Call<StoryResponseWithLoc>, t: Throwable) {
                Log.e("ResponseError", "onFailure: ${t.message}")
            }
        })
    }

    fun uploadStory(token: String, description: String, imgFile: File) {
        val requestDescription = description.toRequestBody("text/plain".toMediaType())
        val requestImage = imgFile.asRequestBody("image/jpeg".toMediaTypeOrNull())
        val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
            "photo",
            imgFile.name,
            requestImage
        )
        _loading.value = true
        val client = apiService.uploadStory("Bearer $token", imageMultipart, requestDescription)
        client.enqueue(object : Callback<StoryResponse> {
            override fun onResponse(call: Call<StoryResponse>, response: Response<StoryResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    _responseUpload.value = response.body()
                    _loading.value = false
                }
            }

            override fun onFailure(call: Call<StoryResponse>, t: Throwable) {
                Log.e("ResponseError", "onFailure: ${t.message}")
                _loading.value = false
            }

        })
    }


}