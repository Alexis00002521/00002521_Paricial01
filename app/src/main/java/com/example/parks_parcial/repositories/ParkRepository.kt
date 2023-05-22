package com.example.parks_parcial.repositories

import com.example.parks_parcial.data.model.ParkModel
import com.example.parks_parcial.data.park

class ParkRepository (private  val parks: MutableList<ParkModel>){
    fun getPark() = parks

    fun addPark(park: ParkModel) = parks.add(park)
}