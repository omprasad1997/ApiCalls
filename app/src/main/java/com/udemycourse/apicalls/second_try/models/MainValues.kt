package com.udemycourse.apicalls.second_try.models

import java.io.Serializable

data class MainValues(
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val temp_min: Double,
    val temp_max: Double,
) : Serializable
