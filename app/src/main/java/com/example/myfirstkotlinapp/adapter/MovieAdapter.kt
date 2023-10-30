package com.example.myfirstkotlinapp.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfirstkotlinapp.R
import com.example.myfirstkotlinapp.model.movie
//import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou



class MovieAdapter(val activity:Activity): RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private var movielist:List<movie>? = null;


    fun setMovieList(list1:List<movie>?){
        this.movielist = list1;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MyViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.movielist,parent,false);
        return MyViewHolder(view);
    }

    override fun onBindViewHolder(holder: MovieAdapter.MyViewHolder, position: Int) {
           holder.bind(movielist?.get(position)!!, activity);
    }

    override fun getItemCount(): Int {
        if(movielist == null) return 0;
        else return movielist?.size!!
    }
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
          val poster_path = view.findViewById<View>(R.id.poster_path) as ImageView;
          val movie_name = view.findViewById<View>(R.id.movieName)as TextView;
          val releaseDay = view.findViewById<View>(R.id.releaseDay) as TextView;

           fun bind(data: movie,activity:Activity){
               movie_name.text = data.original_title;
               releaseDay.text = data.release_date;
              // GlideToVectorYou.justLoadImage(activity, Uri.parse(data.poster_path),poster_path);
               Glide.with(itemView).load("https://www.google.com/url?sa=i&url=https%3A%2F%2Frikumovies.akmalhisyam.my.id%2F&psig=AOvVaw3erUOD8EV8BIDnkAJHHysN&ust=1698671138251000&source=images&cd=vfe&ved=0CBIQjRxqFwoTCKCSzaOpm4IDFQAAAAAdAAAAABAhhttps://image.tmdb.org/t/p/original//3bhkrj58Vtu7enYsRolD1fZdja1.jpg").into(poster_path)
           }
    }

}