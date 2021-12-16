package com.wahyuindra.handphone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.handphone_fragment.*

class HandphoneFragment : Fragment() {

    private var arrHandphone : MutableList<Handphone>? = null

    private var db: AppDatabase? = null
    private var vHandphoneDAO: HandphoneDAO? = null

    companion object {
        fun newInstance(): HandphoneFragment {
            return HandphoneFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.handphone_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        vHandphoneDAO = db?.HandphoneDAO()
    }

    private fun initView() {
        fabAddHandphone.setOnClickListener { (activity as MainActivity).tampilHandphoneAddFragment() }

        //simulasiDataHandphone()
        //tampilHandphone()
        ambilDataHandphone()
    }

    private fun ambilDataHandphone() {

        arrHandphone = ArrayList()
        vHandphoneDAO?.ambilSemuaHandphone()?.observe(viewLifecycleOwner, Observer { r ->

            arrHandphone = r as MutableList<Handphone>?

            when {
                arrHandphone?.size == 0 -> tampilToast("Belum ada data Handphone")

                else -> {
                    tampilHandphone()
                }
            }
        })
    }

    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

//    private fun simulasiDataHandphone() {
//        arrHandphone = ArrayList()
//
//        arrHandphone.add(Handphone(1,"Redmi Note 7", "Android 10", "Snapdragon", "6,2", "48Mp", "RAM 4Gb / Internal 64Gb", "4000MAh", 2000000 ))
//        arrHandphone.add(Handphone(2,"Redmi Note 10", "Android 11", "Mediatech", "6,5", "108Mp", "RAM 4Gb / Internal 128Gb", "5000MAh", 3000000))
//
//    }

    private fun tampilHandphone() {
        listHandphone.layoutManager = LinearLayoutManager(activity)
        listHandphone.adapter = HandphoneAdapter(requireActivity(),
            arrHandphone!! as ArrayList<Handphone>
        )

    }



}