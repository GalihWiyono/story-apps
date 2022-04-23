package com.example.storyapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.storyapp.helper.DataDummy
import com.example.storyapp.helper.MainCoroutineRule
import com.example.storyapp.helper.getOrAwaitValue
import com.example.storyapp.model.LoginResult
import com.example.storyapp.model.LoginUser
import com.example.storyapp.model.RegisterUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UserViewModelTest {
    @get:Rule
    var mainCoroutine = MainCoroutineRule()

    @get:Rule
    var instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var userViewModel: UserViewModel

    @Test
    fun `verify clearUserPreference`() {
        userViewModel.clearUserPreference()
        Mockito.verify(userViewModel).clearUserPreference()
    }

    @Test
    fun `verify saveUserPreference`() {
        val loginResult = DataDummy.generateLoginResult()
        userViewModel.saveUserPreference(loginResult)
        Mockito.verify(userViewModel).saveUserPreference(loginResult)
    }

    @Test
    fun `verify userRegister`() {
        val registerUser = DataDummy.generateRegisterUser()
        userViewModel.userRegister(registerUser)
        Mockito.verify(userViewModel).userRegister(registerUser)
    }

    @Test
    fun `verify userLogin`() {
        val loginUser = DataDummy.generateLoginUser()
        userViewModel.userLogin(loginUser)
        Mockito.verify(userViewModel).userLogin(loginUser)
    }

    @Test
    fun `Should Not Null and Return as Expected when getUserPreference Success`(){
        val dataDummy = DataDummy.generateLoginResult()
        val dataExpected = MutableLiveData<LoginResult>()
        dataExpected.value = dataDummy

        `when`(userViewModel.getUserPreferences()).thenReturn(dataExpected)
        val actualData = userViewModel.getUserPreferences().getOrAwaitValue()

        Mockito.verify(userViewModel).getUserPreferences()
        Assert.assertNotNull(actualData)
        Assert.assertEquals(dataExpected.value, actualData)
    }

    @Test
    fun `Should Not Null and Return as Expected  when Call loginResult`() {
        val dataDummy = DataDummy.generateLoginResult()
        val dataExpected = MutableLiveData<LoginResult>()
        dataExpected.value = dataDummy

        `when`(userViewModel.loginResult).thenReturn(dataExpected)
        val actualData = userViewModel.loginResult.getOrAwaitValue()

        Mockito.verify(userViewModel).loginResult
        Assert.assertNotNull(actualData)
        Assert.assertEquals(dataExpected.value, actualData)
    }

    @Test
    fun `Should Not Null and Return as Expected  when Call isLoading` () {
        val dataExpected = MutableLiveData<Boolean>()
        dataExpected.value = true

        `when`(userViewModel.isLoading).thenReturn(dataExpected)
        val actualData = userViewModel.isLoading.getOrAwaitValue()

        Mockito.verify(userViewModel).isLoading
        Assert.assertNotNull(actualData)
        Assert.assertEquals(dataExpected.value, actualData)
    }

    @Test
    fun `Should Not Null and Return as Expected  when Call userStatus`() {
        val dataExpected = MutableLiveData<Boolean>()
        dataExpected.value = true

        `when`(userViewModel.userStatus).thenReturn(dataExpected)
        val actualData = userViewModel.userStatus.getOrAwaitValue()

        Mockito.verify(userViewModel).userStatus
        Assert.assertNotNull(actualData)
        Assert.assertEquals(dataExpected.value, actualData)
    }
}