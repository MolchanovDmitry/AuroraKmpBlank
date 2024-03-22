package com.example.kmpblank.ext

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.asPromise
import kotlinx.coroutines.async
import com.example.kmpblank.Uuid
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun <T : Any> CoroutineScope.promiseWithEvent(
    enable: Boolean,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): Any {
    return if (enable) {
        val caller = Uuid.v4()
        async(context, start, block).asPromise().then({
            sendEventResponse(caller = caller, response = it)
        }, {
            sendEventError(caller = caller, error = it.message ?: "Error query")
        })
        caller
    } else {
        async(context, start, block).asPromise()
    }
}

fun <T : Any> CoroutineScope.flowWithEvent(
    flow: Flow<T>,
): Any {

        val caller = Uuid.v4()
        flow
            .catch {
                sendEventError(caller = caller, error = it.message ?: "Error query")
            }
            .onEach {
                sendEventResponse(caller = caller, response = it)
            }
            .launchIn(this)

        return caller
}

