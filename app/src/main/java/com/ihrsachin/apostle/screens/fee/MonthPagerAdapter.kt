package com.ihrsachin.apostle.screens.fee

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MonthPagerAdapter(fragment: Fragment, private val monthList: List<String>) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        // Create a new fragment and pass the string as an argument
        val fragment: Fragment = MonthItemFragment()
        val args = Bundle()
        args.putString("string", monthList[position])
        fragment.arguments = args


        return fragment
    }

    override fun getItemCount(): Int {
        // Return the total number of fragments
        return monthList.size
    }
}