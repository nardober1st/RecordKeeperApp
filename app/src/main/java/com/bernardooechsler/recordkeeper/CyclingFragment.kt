package com.bernardooechsler.recordkeeper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// Here we are extending 'Fragment()' class on our CyclingFragment
class CyclingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Here we are inflating our 'fragment_cycling' file and returning it
        return inflater.inflate(R.layout.fragment_cycling, container, false)
    }
}