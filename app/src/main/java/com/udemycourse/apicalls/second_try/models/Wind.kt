package com.udemycourse.apicalls.second_try.models

import java.io.Serializable

data class Wind(
    val speed: Double,
    val deg: Int,
    val gust: Double,
) : Serializable
