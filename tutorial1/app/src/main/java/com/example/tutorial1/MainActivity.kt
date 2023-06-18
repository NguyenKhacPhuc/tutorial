package com.example.tutorial1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.toggleButton2.setOnClickListener {
           startForegroundService(Intent(this, MusicService::class.java))
        }

        binding.toggleButton3.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentView, FragmentA())
                .commit()

            supportFragmentManager.beginTransaction().replace(R.id.fragmentView, FragmentB()).addToBackStack("backStack")
                .commit()
        }
    }
}
