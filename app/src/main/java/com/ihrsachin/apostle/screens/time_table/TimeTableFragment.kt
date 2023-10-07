package com.ihrsachin.apostle.screens.time_table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.TimeTableFragmentBinding
import java.util.Calendar


class TimeTableFragment : Fragment(){

    private lateinit var binding : TimeTableFragmentBinding

    private val days = arrayListOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.time_table_fragment,
            container,
            false
        )


        // Set the adapter for ViewPager2
        binding.viewPager.adapter = TimeTablePagerAdapter(this, days)
        binding.viewPager.currentItem = getCurrentDayOfWeek()


        // Connect the TabLayout with the ViewPager2
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = days[position]
        }.attach()


        return binding.root

    }


    /**
     * @return current day of week starting from "Monday". It return 0 based day index of week
     */
    private fun getCurrentDayOfWeek(): Int {
        val calendar = Calendar.getInstance()

        // 1 based index, starting from "Sunday" (Android's default)
        val currDay = calendar.get(Calendar.DAY_OF_WEEK)

        // Adjust to a 0 based index, starting from "Monday"
        return (currDay + 5) % 7
    }
}