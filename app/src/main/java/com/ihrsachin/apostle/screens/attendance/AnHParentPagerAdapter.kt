package com.ihrsachin.apostle.screens.attendance

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class AnHParentPagerAdapter(fragment: Fragment, private val stringList: List<String>?) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        // Create a new fragment and pass the string as an argument
        return if(position == 0) {
            val fragment = AttendanceFragment()
            val args = Bundle()
            args.putString("string", stringList!![position])
            fragment.arguments = args
            fragment
        } else{
            val fragment = HolidaysFragment()
            val args = Bundle()
            args.putString("string", stringList!![position])
            fragment.arguments = args
            fragment
        }
    }

    override fun getItemCount(): Int {
        // Return the total number of fragments
        return stringList!!.size
    }
}