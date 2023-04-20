package com.bernardooechsler.recordkeeper

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bernardooechsler.recordkeeper.databinding.FragmentRunningBinding


// Here we are extending 'Fragment()' class on our RunningFragment
class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRunningBinding.inflate(inflater, container, false)

        // Returning our 'fragment_running' already inflated
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    // Private so it's only visible by this "RunningFragment" class.
    private fun setupClickListeners() {
        binding.container5km.setOnClickListener {
            launchRunningRecordScreen("5km")
        }
        binding.container10km.setOnClickListener {
            launchRunningRecordScreen("10km")
        }
        binding.containerHalfMarathon.setOnClickListener {
            launchRunningRecordScreen("Half Marathon")
        }
        binding.containerMarathon.setOnClickListener {
            launchRunningRecordScreen("Marathon")
        }
    }

    // This function will open EditRunningRecordActivity
    // Then we will call it inside .setOnClickListener inside setupClickListeners() function
    private fun launchRunningRecordScreen(distance: String) {

        // In an Activity class, we can use the keyword 'this' because that is a context
        // In a Fragment we can't use 'this', because it doesn't have a context. So we use 'context'
        val intent = Intent(context, EditRunningRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }
}