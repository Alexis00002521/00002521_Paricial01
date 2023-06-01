package com.example.parksparcial.ui.park.newpark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parks_parcial.databinding.FragmentnewparkBinding
import com.example.parksparcial.ui.park.viewmodel.ParkViewModel


class NewParkFragment : Fragment() {

    private val parkViewModel: ParkViewModel by activityViewModels {
        ParkViewModel.Factory
    }
    private lateinit var binding: FragmentnewparkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentnewparkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = parkViewModel
    }

    private fun observeStatus() {
        parkViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(ParkViewModel.WRONG_INFORMATION_I) -> {
                    parkViewModel.clearStatus()
                }
                status.equals(ParkViewModel.PARK_CREATED_OK) -> {
                    parkViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}