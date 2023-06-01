package com.example.parksparcial.repositories

import com.example.parksparcial.data.model.ParkModel
class ParkRepository (private  val parks: MutableList<ParkModel>){
    fun getPark() = parks

    fun addPark(park: ParkModel) = parks.add(park)
}