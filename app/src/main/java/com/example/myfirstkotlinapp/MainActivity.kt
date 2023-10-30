package com.example.myfirstkotlinapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstkotlinapp.adapter.MovieAdapter
import com.example.myfirstkotlinapp.databinding.ActivityMainBinding
import com.example.myfirstkotlinapp.model.movieInterface
import com.example.myfirstkotlinapp.retrofit.retrofitInstance
import com.example.myfirstkotlinapp.viewModel.MainAcViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    lateinit var recyclerAdapter:MovieAdapter;
    lateinit var recyclerView:RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);
        val retrofitService = retrofitInstance.getRetroInstance().create(movieInterface::class.java)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView);

        initRecyclerView();
        initViewModel();
    }
    fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this);
         recyclerAdapter = MovieAdapter(this);
        recyclerView.adapter = recyclerAdapter;
    }
    private fun initViewModel(){
        val viewModel:MainAcViewModel = ViewModelProvider(this).get(MainAcViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it != null){
                recyclerAdapter.setMovieList(it)
                recyclerAdapter.notifyDataSetChanged()
            }
            else Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()

        })
        viewModel.makeApiCall()
    }

}


