package com.bernardooechsler.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.commit
import com.bernardooechsler.recordkeeper.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add(R.id.frame_content, RunningFragment())
        }

        supportFragmentManager.commit {
            add(R.id.frame_content, CyclingFragment())
        }

        binding.buttonCycling.setOnClickListener {
            onCyclingClicked()
        }

        binding.buttonRunning.setOnClickListener {
            onRunningClicked()
        }
    }

    private fun onRunningClicked() {

    }

    private fun onCyclingClicked() {

    }
}