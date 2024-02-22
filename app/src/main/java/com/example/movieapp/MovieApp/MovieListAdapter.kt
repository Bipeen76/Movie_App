package com.app.neoleaf.credit.view.MovieApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.neoleaf.credit.databinding.ListItemMovieBinding
import com.app.neoleaf.credit.model.Result
import com.app.neoleaf.credit.network.URLs
import com.example.movieapp.databinding.ListItemMovieBinding
import com.squareup.picasso.Picasso

class MovieListAdapter(var movieList: ArrayList<Result>) :
    RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    lateinit var binding: ListItemMovieBinding

    inner class MovieListViewHolder(var binding: ListItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        binding = ListItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        Picasso.get().load("${URLs.movie_image_base}" + movieList.get(position).poster_path)
            .into(holder.binding.image)
    }
}