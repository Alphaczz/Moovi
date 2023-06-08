package com.example.moovi.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moovi.R
import com.example.moovi.data.model.Movie
import com.example.moovi.databinding.ListItemBinding

class movieAdapter(): RecyclerView.Adapter<movieAdapter.MyViewHolder>()
{
    private val movieList=ArrayList<Movie> ()
    fun setList(movie:List<Movie>)
    {
        movieList.clear()
        movieList.addAll(movie)
    }

    class MyViewHolder(val binding:ListItemBinding)
        :RecyclerView.ViewHolder(binding.root)
    {
            fun bind(movie: Movie)
            {
                binding.titletxtview.text=movie.title
                binding.descriptionTxtView.text=movie.overview
                val posterURL="https://image.tmdb.org/t/p/w500/"+movie.posterPath
                Glide.with(binding.imgview.context).load(posterURL).into(binding.imgview)
            }

        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
 val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding=DataBindingUtil.inflate(layoutInflater,
            R.layout.list_item,
            parent,
            false)
    return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
    return movieList.size    }

}