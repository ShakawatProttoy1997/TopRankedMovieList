package com.example.myfirstkotlinapp.model

import retrofit2.Response
import retrofit2.http.GET

interface movieInterface {
    @GET("/3/movie/top_rated?api_key=c7aaa24216b460d26dec4c4ca258c573")
    suspend fun getMovies(): Response<MovieList>
}