package com.bernardooechsler.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.commit
import com.bernardooechsler.recordkeeper.cycling.CyclingFragment
import com.bernardooechsler.recordkeeper.databinding.ActivityMainBinding
import com.bernardooechsler.recordkeeper.running.RunningFragment
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

// We were using 'OnNavigationItemSelectedListener' before, but it has been deprecated
// After the ' , ', we are adding an interface
class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(/* view = */ binding.root)

        // We were using 'setOnNavigationItemSelectedListener' before, but now, it has been deprecated
        binding.bottomNav.setOnItemSelectedListener(this)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    // We converted the 'when' to expression body
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.reset_running -> {
            Toast.makeText(this, "Clicked the Reset Running Records", Toast.LENGTH_LONG).show()
            true
        }

        R.id.reset_cycling -> {
            Toast.makeText(this, "Clicked the Reset Cycling Records", Toast.LENGTH_LONG).show()
            true
        }

        R.id.reset_all -> {
            Toast.makeText(this, "Clicked the Reset All Records", Toast.LENGTH_LONG).show()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun onRunningClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
        return true
    }

    private fun onCyclingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
        return true
    }

    // We converted to Inline expression body type
    // This function will select which bottom nav item is clicked to be opened
    // We don't need the return type for nav_cycling or/and nav_running because
    // Their onRunningClicked()/onCyclingClicked() already has a return type of 'Boolean' (true/false)
    override fun onNavigationItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.nav_cycling -> onCyclingClicked()
//            true
        R.id.nav_running -> onRunningClicked()
//            true
        else -> false
    }
}