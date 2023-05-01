package com.bernardooechsler.recordkeeper.running

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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

    // Calling the "displayRecords()" function in the onResume() method, will fix the problem with the return button. Obs: not the left-arrow
    // on the upper-left part of the screen
    override fun onResume() {
        super.onResume()
        displayRecords()
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

    // We are using "requireContext()." method instead of only "context?." so we have a non-null version of the context
    // But if we do not have a context, it is not safe to use "requireContext()." because the app will crash, therefore, we use "context?.
    private fun displayRecords() {
        val runningPreferences = requireContext().getSharedPreferences("running", Context.MODE_PRIVATE)

        binding.textView5kmValue.text = runningPreferences.getString("5km record", null)
        binding.textView5kmDate.text = runningPreferences.getString("5km date", null)
        binding.textView10kmValue.text = runningPreferences.getString("10km record", null)
        binding.textView10kmDate.text = runningPreferences.getString("10km date", null)
        binding.textViewHalfMarathonValue.text = runningPreferences.getString("Half Marathon record", null)
        binding.textViewHalfMarathonDate.text = runningPreferences.getString("Half Marathon date", null)
        binding.textViewMarathonValue.text = runningPreferences.getString("Marathon record", null)
        binding.textViewMarathonDate.text = runningPreferences.getString("Marathon date", null)
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