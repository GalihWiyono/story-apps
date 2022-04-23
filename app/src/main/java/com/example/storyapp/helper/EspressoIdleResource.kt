package com.example.storyapp.helper

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdleResource {

    private const val RESOURCE = "GLOBAL"

    @JvmField
    val countingIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        countingIdlingResource.increment()
    }

    fun decrement() {
        if (!countingIdlingResource.isIdleNow) {
            countingIdlingResource.decrement()
        }
    }
}

inline fun <T> wrapEspressoIdleResource(function: () -> T): T {
    EspressoIdleResource.increment() // Set app as busy.
    return try {
        function()
    } finally {
        EspressoIdleResource.decrement() // Set app as idle.
    }
}