package com.example.storyapp.view.ui

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.example.storyapp.R
import com.example.storyapp.helper.EspressoIdleResource
import com.example.storyapp.model.di.Module
import com.example.storyapp.view.adapter.StoryListAdapter
import com.example.storyapp.view.ui.helper.JsonConverter
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class MainActivityTest {

    private val mockWebServer = MockWebServer()

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        mockWebServer.start(8080)
        Module.BASE_URL_API = "http://127.0.0.1:8080/"
        IdlingRegistry.getInstance().register(EspressoIdleResource.countingIdlingResource)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
        IdlingRegistry.getInstance().unregister(EspressoIdleResource.countingIdlingResource)
    }

    @Test
    fun test_CheckingRecyclerViewVisible() {
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(JsonConverter.readDataFromFile("success_response.json"))
        mockWebServer.enqueue(mockResponse)

        //check RecyclerView Visible
        onView(withId(R.id.rv_story)).check(matches(isDisplayed()))
    }

    @Test
    fun test_Scrolling() {
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(JsonConverter.readDataFromFile("success_response.json"))
        mockWebServer.enqueue(mockResponse)

        //check RecyclerView Visible
        onView(withId(R.id.rv_story)).check(matches(isDisplayed()))

        //Scroll Down Than Scroll Up
        onView(withId(R.id.rv_story))
            .perform(scrollToPosition<StoryListAdapter.StoryViewHolder>(9))
            .perform(scrollToPosition<StoryListAdapter.StoryViewHolder>(0))

        //check RecyclerView Visible
        onView(withId(R.id.rv_story)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun test_ScrollAndNavToDetail() {
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(JsonConverter.readDataFromFile("success_response.json"))
        mockWebServer.enqueue(mockResponse)

        //Scroll and Click on Position 3
        onView(withId(R.id.rv_story))
            .perform(actionOnItemAtPosition<StoryListAdapter.StoryViewHolder>(3, click()))

        //Confirm Nav and Check The Id Story
        onView(withId(R.id.tv_id))
            .check(matches(withText("story-HPm5jw4C-AwarOXm")))

        pressBack()

        //Scroll and Click on Position 1
        onView(withId(R.id.rv_story))
            .perform(actionOnItemAtPosition<StoryListAdapter.StoryViewHolder>(1, click()))

        //Confirm Nav and Check The Id Story
        onView(withId(R.id.tv_id))
            .check(matches(withText("story-v322kFIMrdGTSZeD")))

        pressBack()

        //check RecyclerView Visible
        onView(withId(R.id.rv_story)).check(matches(isDisplayed()))
    }
}