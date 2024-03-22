package com.example.kmpblank

import kotlinx.coroutines.delay

class DataVault {

    fun getHelloWorld(): String {
        return "Hello world"
    }

    suspend fun getDelayedHelloWorld(): String {
        delay(5_000)
        return getHelloWorld()
    }
}