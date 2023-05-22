package com.example.parks_parcial.ui.park.parkslist.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parks_parcial.data.model.ParkModel

class ParkRecyclerViewAdapter (
    private val clickListener: (ParkModel) -> Unit)
    : RecyclerView.Adapter<ParkRecyclerViewHolder>()  {
        private val movies = ArrayList<ParkModel>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkRecyclerViewHolder {
            val binding = ParkItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ParkRecyclerViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return movies.size
        }

        override fun onBindViewHolder(holder: ParkRecyclerViewHolder, position: Int) {
            val movie = movies[position]
            holder.bind(movie, clickListener)
        }

        fun setData(moviesList: List<ParkModel>) {
            movies.clear()
            movies.addAll(moviesList)
        }
    }
