package com.cesarynga.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList: List<Movie>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        movieList?.let { movies ->
            holder.bind(movies[position])
        }
    }

    override fun getItemCount(): Int = movieList?.size ?: 0

    fun setMovies(list: List<Movie>) {
        this.movieList = list
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgMoviePoster: ImageView = itemView.findViewById(R.id.imgMoviePoster)
        private val screenWidth = itemView.context.resources.displayMetrics.widthPixels

        fun bind(movie: Movie) {
            Picasso.get()
                .load(movie.imageUrl)
                .resize(screenWidth / 2, screenWidth / 2 * 1000 / 674)
                .into(imgMoviePoster)
        }
    }
}