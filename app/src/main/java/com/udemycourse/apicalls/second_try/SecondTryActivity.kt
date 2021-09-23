package com.udemycourse.apicalls.second_try

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.udemycourse.apicalls.R
import com.udemycourse.apicalls.second_try.models.WeatherResponseByZipCode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondTryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_try_activity)

        val zipCode = 431605
        val country = "us"
        getWeatherResponseByZipCode(zipCode,country)

    }

    private fun getWeatherResponseByZipCode(zipCode: Int,country:String) {

        //created retrofit instance
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: WeatherService = retrofit.create(WeatherService::class.java)
        val ll = LatLang(zipCode,country)

        val listCall: Call<WeatherResponseByZipCode> = service.getWeather(ll, Constants.API_ID)


        listCall.enqueue(object : Callback<WeatherResponseByZipCode> {
            override fun onResponse(
                call: Call<WeatherResponseByZipCode>,
                response: Response<WeatherResponseByZipCode>
            ) {
                if (response.isSuccessful) {
                    val weatherList = response.body()
                    val weatherListInStringFormat = Gson().toJson(weatherList)
                    Log.i("onResponse: ", weatherListInStringFormat)
                } else {
                    val rc = response.code()

                    when (rc) {
                        400 -> {
                            Log.e("Error 400", "Bad connection")
                        }
                        404 -> {
                            Log.e("Error 404", "Not found")
                        }
                        else -> {
                            Log.e("Error", "Generic Error")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<WeatherResponseByZipCode>, t: Throwable) {
                Log.e("Errorrrrr", t.message.toString())
            }
        })
    }
}

