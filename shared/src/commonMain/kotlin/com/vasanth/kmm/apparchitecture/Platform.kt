package com.vasanth.kmm.apparchitecture

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform