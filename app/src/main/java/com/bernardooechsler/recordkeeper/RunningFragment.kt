package com.bernardooechsler.recordkeeper

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
}