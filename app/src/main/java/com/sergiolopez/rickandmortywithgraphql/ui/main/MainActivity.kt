package com.sergiolopez.rickandmortywithgraphql.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sergiolopez.rickandmortywithgraphql.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}