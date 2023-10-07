package com.ihrsachin.apostle.screens.time_table

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class TimeTablePagerAdapter(fragment: Fragment, private val stringList: List<String>?) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        // Create a new fragment and pass the string as an argument
        val fragment: Fragment = TimeTableItemFragment()
        val args = Bundle()
        args.putString("string", stringList!![position])
        fragment.arguments = args


        return fragment
    }

    override fun getItemCount(): Int {
        // Return the total number of fragments
        return stringList!!.size
    }
}