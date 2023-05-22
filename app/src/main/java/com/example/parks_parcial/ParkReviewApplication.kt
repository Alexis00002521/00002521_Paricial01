package com.example.parks_parcial

import android.app.Application
import com.example.parks_parcial.data.parks
import com.example.parks_parcial.repositories.ParkRepository

class ParkReviewApplication : Application() {
    val parkRepository: ParkRepository by lazy {
        ParkRepository(parks)
    }
}