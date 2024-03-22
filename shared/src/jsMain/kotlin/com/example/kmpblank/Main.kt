package com.example.kmpblank

import com.example.kmpblank.ext.sendEvent

fun main() {}

/**
 * Js service HTTP request
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
val ServiceRequestReact = ServiceRequestJS()

/**
 * Init fun for run after ready index.html
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
fun init() = sendEvent("Init")

/**
 * NPM package for generate UUID
 */
@JsModule("uuid")
@JsNonModule
external object Uuid {
    fun v4(): String
}
