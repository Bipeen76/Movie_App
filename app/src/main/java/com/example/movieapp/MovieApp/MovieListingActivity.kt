package com.app.neoleaf.credit.view.MovieApp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.MovieApp.BaseActivity
import com.example.movieapp.ViewModel.MovieListViewModel
import com.example.movieapp.databinding.MovieListActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListingActivity : BaseActivity() {
    private val movieViewModel: MovieListViewModel by viewModels()
    lateinit var binding: MovieListActivityBinding
    var movieListAdapter: MovieListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MovieListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // hit the movie list APi
        getMovieList()
    }

    fun getMovieList() {
        showProgress("Please Wait")
        movieViewModel.getPopularList(1).invokeOnCompletion {
            dismissProgress()
            // start the recyclerview
            setAdaptor()
        }
    }

    fun setAdaptor() {
        if (movieViewModel.movieListData.value!!.results.isNotEmpty()) {
            movieListAdapter = MovieListAdapter(movieViewModel.movieListData.value!!.results)
            binding.rvMovieList.apply {
                layoutManager = GridLayoutManager(this@MovieListingActivity, 2)
                adapter = movieListAdapter
            }
        } else {
            Toast.makeText(this@MovieListingActivity, "No Data Found", Toast.LENGTH_LONG).show()
        }
    }

    fun showProgress(msg: String?) {
        showProgressDialog(msg)
    }

    fun dismissProgress() {
        dismissProgressDialog()
    }
}