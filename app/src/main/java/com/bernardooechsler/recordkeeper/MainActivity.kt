package com.bernardooechsler.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.commit
import com.bernardooechsler.recordkeeper.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnNavigationItemSelectedListener(this)

//        // We are creating an anonymous class using the keyword 'object'
//        binding.buttonCycling.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//                onCyclingClicked()
//            }
//        })
//
//        // This is the same code from above but here we are implementing a lambda
//        binding.buttonRunning.setOnClickListener {
//            onRunningClicked()
//        }
    }

    private fun onRunningClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
    }

    private fun onCyclingClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
    }

    // This function will select which bottom nav item is clicked to be opened
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_cycling) {
            onCyclingClicked()
            return true
        } else if (item.itemId == R.id.nav_running) {
            onRunningClicked()
            return true
        } else {
            return false
        }
    }
}