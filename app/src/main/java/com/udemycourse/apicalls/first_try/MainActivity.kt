package com.udemycourse.apicalls.first_try

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.udemycourse.apicalls.R
import retrofit2.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface = ApiInterface.create().getMovies()

        apiInterface.enqueue(object: Callback<List<Movies>>{
            override fun onResponse(call: Call<List<Movies>>, response: Response<List<Movies>>) {

                if(response?.body() != null){
                    val movieList: List<Movies>? = response.body()
                    val movieListResponseJsonString = Gson().toJson(movieList)
                    Log.i("Response result", "$movieList")
                }
            }

            override fun onFailure(call: Call<List<Movies>>, t: Throwable) {
                Log.e("Errorrrrr", t.message.toString())
            }

        })
    }
}