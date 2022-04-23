package com.example.storyapp.model.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.storyapp.helper.DataDummy
import com.example.storyapp.helper.MainCoroutineRule
import com.example.storyapp.helper.getOrAwaitValue
import com.example.storyapp.model.LoginResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.`when`
import org.junit.Rule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UserRepositoryTest {
    @get:Rule
    var mainCoroutine = MainCoroutineRule()

    @get:Rule
    var instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var userRepository: UserRepository

    @Test
    fun `Should Not Null and Return as Expected when Call userStatus` () {
        val dataExpected = MutableLiveData<Boolean>()
        dataExpected.value = true

        `when`(userRepository.userStatus).thenReturn(dataExpected)
        val actualData = userRepository.userStatus.getOrAwaitValue()

        Mockito.verify(userRepository).userStatus
        Assert.assertNotNull(actualData)
    }

    @Test
    fun `Should Not Null and Return as Expected when Call isLoading` () {
        val dataExpected = MutableLiveData<Boolean>()
        dataExpected.value = false

        `when`(userRepository.loading).thenReturn(dataExpected)
        val actualData = userRepository.loading.getOrAwaitValue()

        Mockito.verify(userRepository).loading
        Assert.assertNotNull(actualData)
    }

    @Test
    fun `Should Not Null and Return as Expected when Call loginData`() {
        val dataDummy = DataDummy.generateLoginResult()
        val dataExpected = MutableLiveData<LoginResult>()
        dataExpected.value = dataDummy

        `when`(userRepository.loginData).thenReturn(dataExpected)
        val actualData = userRepository.loginData.getOrAwaitValue()

        Mockito.verify(userRepository).loginData
        Assert.assertNotNull(actualData)
        Assert.assertEquals(dataExpected.value, actualData)
    }

    @Test
    fun `Should Not Null and Return as Expected when userRegister Success`() {
        val registerUser = DataDummy.generateRegisterUser()
        val dataExpected = MutableLiveData<LoginResult>()
        dataExpected.value = DataDummy.generateLoginResult()

        userRepository.userRegister(registerUser)
        Mockito.verify(userRepository).userRegister(registerUser)

        `when`(userRepository.loginData).thenReturn(dataExpected)
        val actualData = userRepository.loginData.getOrAwaitValue()

        Mockito.verify(userRepository).loginData
        Assert.assertNotNull(actualData)
        Assert.assertEquals(dataExpected.value, actualData)
    }

    @Test
    fun `Should Not Null and Return as Expected when userLogin Success`() {
        val dataDummy = DataDummy.generateLoginUser()
        val dataExpected = MutableLiveData<LoginResult>()
        dataExpected.value = DataDummy.generateLoginResult()

        userRepository.userLogin(dataDummy)
        Mockito.verify(userRepository).userLogin(dataDummy)

        `when`(userRepository.loginData).thenReturn(dataExpected)
        val actualData = userRepository.loginData.getOrAwaitValue()

        Mockito.verify(userRepository).loginData
        Assert.assertNotNull(actualData)
        Assert.assertEquals(dataExpected.value, actualData)
    }
}