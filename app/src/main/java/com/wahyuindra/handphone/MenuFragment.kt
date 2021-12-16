package com.wahyuindra.handphone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.menu_fragment.*

class MenuFragment : Fragment() {

    companion object {
        fun newInstance(): MenuFragment {
            return MenuFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        card_handphone.setOnClickListener { (activity as MainActivity).tampilHandphoneFragment() }
        card_tambah.setOnClickListener { (activity as MainActivity).tampilHandphoneAddFragment() }
        card_biodata.setOnClickListener { (activity as MainActivity).tampilBiodataFragment() }
        card_info.setOnClickListener { tampilToast("Tugas UAS Pemrograman Piranti Bergerak 1B") }
    }

    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

}