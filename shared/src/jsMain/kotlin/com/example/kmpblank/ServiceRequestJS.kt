package com.example.kmpblank

import com.example.kmpblank.ext.promiseWithEvent
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope

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
    private val isEvent: Boolean
) {
    @OptIn(DelicateCoroutinesApi::class)
    fun repos() = GlobalScope.promiseWithEvent(isEvent) {
        "kokoke"
    }
}