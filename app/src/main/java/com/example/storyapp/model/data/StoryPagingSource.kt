package com.example.storyapp.model.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.storyapp.helper.wrapEspressoIdleResource
import com.example.storyapp.model.ListStoryItem
import com.example.storyapp.model.UserPreference
import com.example.storyapp.model.service.ApiService
import kotlinx.coroutines.flow.first
import java.lang.Exception
import javax.inject.Inject

class StoryPagingSource @Inject constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference
) : PagingSource<Int, ListStoryItem>() {
    override fun getRefreshKey(state: PagingState<Int, ListStoryItem>): Int? {
        return state.anchorPosition?.let { position ->
            val anchorPage = state.closestPageToPosition(position)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListStoryItem> {
        return try {
            val position = params.key ?: INIT_PAGE_INDEX
            val token = userPreference.getUserData().first().token
            wrapEspressoIdleResource {
                if (token.trim().isNotEmpty()) {
                    Log.d("token", "load: $token")
                    val responseData =
                        apiService.getAllStoriesPaging("Bearer $token", position, params.loadSize)
                    Log.d("tag", "load: ${responseData.message()}")
                    if (responseData.isSuccessful) {
                        Log.d("token", "load Ga Error: ${responseData.body()}")
                        LoadResult.Page(
                            data = responseData.body()?.listStory ?: emptyList(),
                            prevKey = if (position == 1) null else position - 1,
                            nextKey = if (responseData.body()?.listStory.isNullOrEmpty()) null else position + 1
                        )
                    } else {
                        Log.d("token", "load Error: $token")
                        LoadResult.Error(Exception("Gagal"))
                    }
                } else {
                    Log.d("tag", "load: Data Error2")
                    LoadResult.Error(Exception("Gagal"))
                }
            }
        } catch (e: Exception) {
            Log.d("exception", "load: Error ${e.message}")
            return LoadResult.Error(e)
        }
    }

    private companion object {
        const val INIT_PAGE_INDEX = 1
    }
}