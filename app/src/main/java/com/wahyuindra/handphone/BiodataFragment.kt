package com.wahyuindra.handphone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import androidx.activity.OnBackPressedCallback


class BiodataFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                (activity as MainActivity).tampilMenuFragment()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        return inflater.inflate(R.layout.biodata_fragment, container, false)
    }

    companion object {
        fun newInstance() : BiodataFragment {
            return BiodataFragment()
        }
    }





}
