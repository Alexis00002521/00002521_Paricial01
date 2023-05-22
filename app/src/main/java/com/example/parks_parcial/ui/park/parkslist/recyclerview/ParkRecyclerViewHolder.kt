package com.example.parks_parcial.ui.park.parkslist.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.parks_parcial.data.model.ParkModel


class ParkRecyclerViewHolder (private val binding: PakItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(park: ParkModel, clickListener: (ParkModel) -> Unit) {
        binding.TV_name.text = park.name
        binding.Tv_location.text = park.location

        binding.parkItemCardView.setOnClickListener {
            clickListener(park)
        }
    }
}