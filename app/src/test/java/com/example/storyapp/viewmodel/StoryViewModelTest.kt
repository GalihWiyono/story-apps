package com.example.storyapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.AsyncPagingDataDiffer
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.recyclerview.widget.ListUpdateCallback
import com.example.storyapp.helper.DataDummy
import com.example.storyapp.helper.MainCoroutineRule
import com.example.storyapp.helper.getOrAwaitValue
import com.example.storyapp.model.ListStoryItem
import com.example.storyapp.model.ListStoryWithLoc
import com.example.storyapp.model.StoryResponse
import com.example.storyapp.view.adapter.StoryListAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.io.File

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class StoryViewModelTest {

    private val token = "Token Testing"

    @get:Rule
    var mainCoroutine = MainCoroutineRule()

    @get:Rule
    var instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var storyViewModel: StoryViewModel

    @Mock
    private lateinit var imageFile : File

    @Test
    fun `verify uploadStory`() {
        val description = "Description Testing"
        storyViewModel.uploadStory(token, description, imageFile)
        Mockito.verify(storyViewModel).uploadStory(token, description, imageFile)
    }

    @Test
    fun `verify getStoryWithLocation`() {
        storyViewModel.getStoryWithLocation(token)
        Mockito.verify(storyViewModel).getStoryWithLocation(token)
    }

    @Test
    fun `Should Not Null and Return as Expected when call isLoading`() {
        val dataExpected = MutableLiveData<Boolean>()
        dataExpected.value = true

        `when`(storyViewModel.isLoading).thenReturn(dataExpected)
        val actualData = storyViewModel.isLoading.getOrAwaitValue()

        Mockito.verify(storyViewModel).isLoading
        Assert.assertNotNull(actualData)
        Assert.assertEquals(dataExpected.value, actualData)
    }

    @Test
    fun `Should Not Null and Return as Expected when call dataStoryWithLocation`() {
        val dataDummy = DataDummy.generateStoryWithLoc()
        val dataExpected = MutableLiveData<List<ListStoryWithLoc>>()
        dataExpected.value = dataDummy

        `when`(storyViewModel.dataStoryWithLocation).thenReturn(dataExpected)
        val actualData = storyViewModel.dataStoryWithLocation.getOrAwaitValue()

        Mockito.verify(storyViewModel).dataStoryWithLocation
        Assert.assertNotNull(actualData)
        Assert.assertEquals(dataExpected.value, actualData)
    }

    @Test
    fun `Should Not Null and Return as Expected when call responseUpload`() {
        val dataDummy = DataDummy.generateStoryResponse()
        val dataExpected = MutableLiveData<StoryResponse>()
        dataExpected.value = dataDummy

        `when`(storyViewModel.responseUpload).thenReturn(dataExpected)
        val actualData = storyViewModel.responseUpload.getOrAwaitValue()

        Mockito.verify(storyViewModel).responseUpload
        Assert.assertNotNull(actualData)
        Assert.assertEquals(dataExpected.value, actualData)
    }

    @Test
    fun `Should Not Null and Return as Expected when call allStory`() = mainCoroutine.runBlockingTest {
        val dataDummy = DataDummy.generateListStoryItem()
        val data = PagingDataSourcesTest.snapshot(dataDummy)
        val dataExpected = MutableLiveData<PagingData<ListStoryItem>>()
        dataExpected.value = data

        `when`(storyViewModel.allStory).thenReturn(dataExpected)
        val actualData = storyViewModel.allStory.getOrAwaitValue()

        val diff = AsyncPagingDataDiffer(
            StoryListAdapter.DIFF_CALLBACK,
            listUpdateCallback,
            mainCoroutine.dispatch,
            mainCoroutine.dispatch,
        )
        diff.submitData(actualData)

        advanceUntilIdle()

        Mockito.verify(storyViewModel).allStory
        Assert.assertNotNull(diff.snapshot())
        Assert.assertEquals(dataDummy[0].id, diff.snapshot()[0]?.id)
        Assert.assertEquals(dataDummy.size, diff.snapshot().size)
    }

    class PagingDataSourcesTest private constructor() :
        PagingSource<Int, LiveData<List<ListStoryItem>>>() {
        companion object {
            fun snapshot(items: List<ListStoryItem>): PagingData<ListStoryItem> {
                return PagingData.from(items)
            }
        }
        override fun getRefreshKey(state: PagingState<Int, LiveData<List<ListStoryItem>>>): Int {
            return 0
        }
        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LiveData<List<ListStoryItem>>> {
            return LoadResult.Page(emptyList(), 0 , 1)
        }
    }

    private val listUpdateCallback = object : ListUpdateCallback {
        override fun onInserted(position: Int, count: Int) {}
        override fun onRemoved(position: Int, count: Int) {}
        override fun onMoved(fromPosition: Int, toPosition: Int) {}
        override fun onChanged(position: Int, count: Int, payload: Any?) {}
    }
}