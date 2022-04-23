package com.example.storyapp.view.ui.helper

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import java.io.IOException
import java.io.InputStreamReader
import java.lang.StringBuilder

object JsonConverter {
    fun readDataFromFile(fileName : String): String {
        try {
            val applicationContext = ApplicationProvider.getApplicationContext<Context>()
            val input = applicationContext.assets.open(fileName)
            val builder = StringBuilder()
            val reader = InputStreamReader(input, "UTF-8")
            reader.readLines().forEach{ string ->
                builder.append(string)
            }
            return builder.toString()
        } catch (exception : IOException) {
            throw exception
        }
    }
}