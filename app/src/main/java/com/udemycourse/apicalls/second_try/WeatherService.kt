package com.udemycourse.apicalls.second_try

import com.udemycourse.apicalls.second_try.models.WeatherResponseByZipCode
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("2.5/weather")
    fun getWeather(
        @Query("ll") ll:LatLang,
        @Query("appid") appid:String
    ) : Call<WeatherResponseByZipCode>
}