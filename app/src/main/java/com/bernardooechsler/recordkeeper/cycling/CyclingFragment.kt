package com.bernardooechsler.recordkeeper.cycling

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bernardooechsler.recordkeeper.databinding.FragmentCyclingBinding

// Here we are extending 'Fragment()' class on our CyclingFragment
class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentCyclingBinding.inflate(inflater, container, false)

        // Returning our 'fragment_cycling' already inflated
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    // Private so it's only visible by this "CyclingFragment" class.
    private fun setupClickListeners() {
        binding.containerLongestRide.setOnClickListener {
            launchCyclingRecordScreen("Longest Ride")
        }
        binding.containerBiggestClimb.setOnClickListener {
            launchCyclingRecordScreen("Biggest Climb")
        }
        binding.containerBestSpeed.setOnClickListener {
            launchCyclingRecordScreen("Best Speed")
        }
    }

    // This function will open EditCyclingRecordActivity
    // Then we will call it inside .setOnClickListener inside setupClickListeners() function
    private fun launchCyclingRecordScreen(record: String) {

        // In an Activity class, we can use the keyword 'this' because that is a context
        // In a Fragment we can't use 'this', because it doesn't have a context. So we use 'context'
        val intent = Intent(context, EditCyclingRecordActivity::class.java)
        intent.putExtra("Record", record)
        startActivity(intent)
    }
}