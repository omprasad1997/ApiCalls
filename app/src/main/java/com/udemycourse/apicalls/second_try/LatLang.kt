package com.udemycourse.apicalls.second_try

data class LatLang(

    val zip: Int,
    val country: String
) {
    override fun toString(): String {
        return String.format("$zip,$country",zip,country)
    }
}




