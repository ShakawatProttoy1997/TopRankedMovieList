package com.example.myfirstkotlinapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfirstkotlinapp.model.movie
import com.example.myfirstkotlinapp.retrofit.retrofitInstance
import com.example.myfirstkotlinapp.retrofit.retrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainAcViewModel: ViewModel() {
    lateinit var liveDatalist:MutableLiveData<List<movie>?> ;
    init{
        liveDatalist = MutableLiveData();

    }
    fun getLiveDataObserver():MutableLiveData<List<movie>?>{
           return liveDatalist;
    }
    fun makeApiCall(){
        val retroInstance = retrofitInstance.getRetroInstance();
        val retService = retroInstance.create(retrofitService::class.java)
        val call = retService.getMovieList();
        call.enqueue(object : Callback<List<movie>>{
            override fun onResponse(call: Call<List<movie>>, response: Response<List<movie>>) {
                liveDatalist.postValue(response.body())
            }
            override fun onFailure(call: Call<List<movie>>, t: Throwable) {
            liveDatalist.postValue(null)
        }



        })

    }

}