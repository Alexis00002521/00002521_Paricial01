package com.example.parksparcial.ui.park.parkslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parks_parcial.R
import com.example.parks_parcial.databinding.FragmentparkinformationBinding
import com.example.parksparcial.data.model.ParkModel
import com.example.parksparcial.ui.park.parkslist.recyclerview.ParkRecyclerViewAdapter
import com.example.parksparcial.ui.park.viewmodel.ParkViewModel




class ParkListFragment : Fragment() {
    private val parkViewModel: ParkViewModel by activityViewModels {
        ParkViewModel.Factory
    }

    private lateinit var adapter: ParkRecyclerViewAdapter

     lateinit var binding: FragmentparkinformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding =  FragmentparkinformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnNew_Park.setOnClickListener{
            parkViewModel.clearData()
            it.findNavController
        }
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = ParkRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recyclerView.adapter = adapter
        displayPark()
    }

    private fun showSelectedItem(park: ParkModel) {
        parkViewModel.setSelectedPark(park)
        findNavController().navigate(R.id.action_park_ListFragment_to_park_InformationFragment)
    }

    private fun displayPark() {
        adapter.setData(parkViewModel.getParks())
        adapter.notifyDataSetChanged()
    }

}