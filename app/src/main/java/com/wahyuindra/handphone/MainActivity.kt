package com.wahyuindra.handphone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tampilMenuFragment()
    }

    private fun gantiFragment(
        fragmentManager: FragmentManager,
        fragment: Fragment, frameId: Int
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)

        transaction.commit()
    }

    fun tampilMenuFragment() {
        gantiFragment(supportFragmentManager, MenuFragment.newInstance(), R.id.contentFrame)
    }

    fun tampilHandphoneFragment() {
        gantiFragment(supportFragmentManager, HandphoneFragment.newInstance(), R.id.contentFrame)
    }

    fun tampilHandphoneAddFragment() {
        gantiFragment(supportFragmentManager, HandphoneAddFragment.newInstance(), R.id.contentFrame)
    }

    fun tampilBiodataFragment() {
        gantiFragment(supportFragmentManager, BiodataFragment.newInstance(), R.id.contentFrame)
    }

}