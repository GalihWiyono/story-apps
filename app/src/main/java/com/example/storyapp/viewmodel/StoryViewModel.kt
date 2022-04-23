package com.example.storyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.storyapp.model.*
import com.example.storyapp.model.repo.StoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor(private val storyRepository: StoryRepository) :
    ViewModel() {

    val allStory: LiveData<PagingData<ListStoryItem>> =
        storyRepository.getStoriesPaging().cachedIn(viewModelScope)

    val dataStoryWithLocation: LiveData<List<ListStoryWithLoc>> = storyRepository.storyWithLocation

    val isLoading: LiveData<Boolean> = storyRepository.loading

    val responseUpload : LiveData<StoryResponse> = storyRepository.responseUpload

    fun getStoryWithLocation(token: String) {
        storyRepository.getStoriesWithLocation(token)
    }

    fun uploadStory(
        token: String,
        description: String,
        imgFile: File
    ) {
        storyRepository.uploadStory(token, description, imgFile)
    }

}