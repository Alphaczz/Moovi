package com.example.moovi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moovi.R
import com.example.moovi.databinding.ActivityMainBinding
import com.example.moovi.presentation.di.Injector
import okhttp3.internal.notify
import javax.inject.Inject

// apikey=7b014b31b0a50f23a359441787152993
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory:viewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: movieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel=ViewModelProvider(this,factory).get(MovieViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        adapter= movieAdapter()
binding.recyclerView.adapter=adapter
        displayPopularMovie()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }

    private fun displayPopularMovie() {
        binding.movieProgressbar.visibility= View.VISIBLE
        val responseLiveData=movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it!=null)
            {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressbar.visibility=View.GONE

            }
            else{
                binding.movieProgressbar.visibility=View.GONE
                Toast.makeText(applicationContext,"no Data Available",Toast.LENGTH_SHORT)
            }
        })
    }
    private fun updateMovies() {
        binding.movieProgressbar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {

            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressbar.visibility = View.GONE
            } else {
                binding.movieProgressbar.visibility = View.GONE

            }
        })
    }
    }