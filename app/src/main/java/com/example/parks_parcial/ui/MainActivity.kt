package com.example.parks_parcial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parks_parcial.R

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}