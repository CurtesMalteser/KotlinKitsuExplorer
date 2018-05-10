package com.curtesmalteser.kotlinkitsuexplorer.activity

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.curtesmalteser.kotlinkitsuexplorer.R

/**
 * Created by anton on 10/05/2018.
 */

class AnimeListAdapter(private val context: Context, private val animeList: List<AnimeViewModel>) : RecyclerView.Adapter<AnimeListAdapter.ListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_row, parent, false)
        return ListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.textViewName.setText(animeList[position].title)
        holder.textViewRating.setText(animeList[position].rating)

        Glide.with(context)
                .load(animeList[position].posterUrl)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_launcher_background))
                .into(holder.imageView)
        Log.d("AJDB", "onBindViewHolder: " + animeList[position].posterUrl)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    inner class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView
        var textViewName: TextView
        var textViewRating: TextView

        init {

            imageView = itemView.findViewById(R.id.imageView)
            textViewName = itemView.findViewById(R.id.textViewName)
            textViewRating = itemView.findViewById(R.id.textViewRating)
        }
    }
}
