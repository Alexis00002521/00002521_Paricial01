package com.example.parksparcial.ui.park.parkslist.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.parksparcial.data.model.ParkModel


class ParkRecyclerViewHolder (private val binding: ParkItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(park: ParkModel, clickListener: (ParkModel) -> Unit) {
        binding.TVname.text = park.name
        binding.Tvlocation.text = park.location

        binding.parkItemCardView.setOnClickListener {
            clickListener(park)
        }
    }
}