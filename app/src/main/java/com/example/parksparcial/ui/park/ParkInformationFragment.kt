package com.example.parksparcial.ui.park

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.parks_parcial.databinding.FragmentparkinformationBinding
import com.example.parksparcial.ui.park.viewmodel.ParkViewModel

class ParkInformationFragment : Fragment() {
    private val parkViewModel: ParkViewModel by activityViewModels{
        ParkViewModel.Factory
    }
    private lateinit var binding: FragmentparkinformationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentparkinformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = parkViewModel
    }

}