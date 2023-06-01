package com.example.parksparcial

import android.app.Application
import com.example.parksparcial.data.parks
import com.example.parksparcial.repositories.ParkRepository

class ParkReviewApplication : Application() {
    val parkRepository: ParkRepository by lazy {
        ParkRepository(parks)
    }
}