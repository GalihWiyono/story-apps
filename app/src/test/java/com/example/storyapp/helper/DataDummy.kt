package com.example.storyapp.helper

import com.example.storyapp.model.*

object DataDummy {

    fun generateListStoryItem(): List<ListStoryItem> {
        val items: MutableList<ListStoryItem> = arrayListOf()
        for (i in 0..100) {
            val item = ListStoryItem(
                "photo $i",
                "date $i",
                "name $i",
                "description $i",
                "id $i"
            )
            items.add(item)
        }
        return items
    }

    fun generateStoryWithLoc() : List<ListStoryWithLoc> {
        val items: MutableList<ListStoryWithLoc> = arrayListOf()
        for (i in 0..100) {
            val data = ListStoryWithLoc(
                "Photo $i",
                "Date $i",
                "Name $i",
                "Description $i",
                "Lon $i",
                "Id $i",
                "Lat $i"
            )
            items.add(data)
        }
        return items
    }

    fun generateStoryResponse(): StoryResponse {
        return StoryResponse(false, "Berhasil")
    }

    fun generateLoginUser() : LoginUser {
        return LoginUser("testemail@gmail.com", "testPassword")
    }

    fun generateLoginResult() : LoginResult {
        return LoginResult("Name Testing", "UserId Testing", "Token Testing")
    }

    fun generateRegisterUser() : RegisterUser {
        return RegisterUser("testingName", "testemail@gmail.com", "testPassword")
    }

}