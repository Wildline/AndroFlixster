package com.example.latestmovielistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latestmovielistapp.R.id

class LatestMoviesRecyclerViewAdapter (
    private val movies: List<LatestMovie>,
    private val mListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<LatestMoviesRecyclerViewAdapter.MovieViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_latest_movie, parent, false)
            return MovieViewHolder(view)
        }


        inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            var mItem: LatestMovie? = null
            val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
            val mMovieOverview: TextView = mView.findViewById<View>(id.movie_overview) as TextView
            val mMovieImage: ImageView = mView.findViewById<ImageView>(id.movie_image)

            override fun toString(): String {
                return mMovieTitle.toString() + " '" + mMovieOverview.text + "'"
            }
        }

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie = movies[position]

            holder.mItem = movie
            holder.mMovieTitle.text = movie.title
            holder.mMovieOverview.text = movie.overview

            Glide.with(holder.mView)
                .load("https://image.tmdb.org/t/p/w500/"+movie.posterPath)
                .centerInside()
                .into(holder.mMovieImage)


            holder.mView.setOnClickListener {
                holder.mItem?.let { movie ->
                    mListener?.onItemClick(movie)
                }
            }
        }


        override fun getItemCount(): Int {
            return movies.size
        }
}
