package com.example.kmpblank

import com.example.kmpblank.ext.flowWithEvent
import com.example.kmpblank.ext.promiseWithEvent
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

/**
 * JS service network
 */
@JsExport
@OptIn(ExperimentalJsExport::class)
class ServiceRequestJS {

    val get by lazy { GetRequestJS(false) }
    val getEvent by lazy { GetRequestJS(true) }
}

@JsExport
@OptIn(ExperimentalJsExport::class)
@Suppress("unused", "NON_EXPORTABLE_TYPE")
class GetRequestJS(
    private val isEvent: Boolean,
) {
    @OptIn(DelicateCoroutinesApi::class)
    fun getHelloWorld() = GlobalScope.promiseWithEvent(isEvent) {
        "Привет, Аврора"
    }

    fun getDelayedHelloWorld()  = GlobalScope.promiseWithEvent(isEvent) {
        delay(5_000)
        "Отложенное сообщение"
    }

    fun getTimer() = GlobalScope.flowWithEvent(flow<Int>{
        for (i in 0 until 1_000_000){
            delay(1000)
            emit(i)
        }
    })
}