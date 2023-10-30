package com.example.myfirstkotlinapp.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofitInstance {
    companion object{
        val base_url = "https://api.themoviedb.org/"
        fun getRetroInstance(): Retrofit{
            return Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build();
        }
    }
}