package com.example.parksparcial.ui.park.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parksparcial.ParkReviewApplication
import com.example.parksparcial.data.model.ParkModel
import com.example.parksparcial.repositories.ParkRepository

class ParkViewModel(private val repository: ParkRepository) : ViewModel(){
    var name = MutableLiveData("")
    var location = MutableLiveData("")
    var status = MutableLiveData("")

    fun getParks() = repository.getPark()

    private fun addParks(park: ParkModel) = repository.addPark(park)

    fun createPark() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION_I
            return
        }

        val park = ParkModel(
            name.value!!,
            location.value!!,

        )

        addParks(park)
        clearData()

        status.value = PARK_CREATED_OK
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            location.value.isNullOrEmpty() -> return false

        }
        return true
    }

    fun clearData() {
        name.value = ""
        location.value = ""

    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedPark(park: ParkModel) {
        name.value = park.name
        location.value = park.location

    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ParkReviewApplication
                ParkViewModel(app.parkRepository)
            }
        }

        const val PARK_CREATED_OK = "Park created"
        const val WRONG_INFORMATION_I = "Wrong information"
        const val INACTIVE = ""
    }
}