package com.example.myfirstkotlinapp.retrofit

import com.example.myfirstkotlinapp.model.movie
import retrofit2.Call
import retrofit2.http.GET

interface retrofitService {
    @GET("3/movie/top_rated?api_key=c7aaa24216b460d26dec4c4ca258c573")
    fun getMovieList(): Call<List<movie>>
}