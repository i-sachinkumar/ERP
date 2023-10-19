package com.ihrsachin.apostle.screens.time_table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.helper.widget.MotionEffect.AUTO
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


        // Connect the TabLayout with the ViewPager2
//        TabLayoutMediator(
//            binding.tabLayout, binding.viewPager
//        ) { tab: TabLayout.Tab, position: Int ->
//            tab.text = days[position]
//            if (tab.isSelected) {
//                // Inflate the custom tab layout for the selected tab
//                val customView = LayoutInflater.from(requireContext())
//                    .inflate(R.layout.custom_tab_layout, null)
//                // Set the custom view for the selected tab
//                tab.customView = customView
//            }
//        }.attach()
//

        // Connect the TabLayout with the ViewPager2
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
                tab.text = days[position]
        }.attach()



        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // Create a custom view for the selected tab
                val customView = LayoutInflater.from(requireContext())
                    .inflate(R.layout.time_table_custom_tab_layout, null)
                customView.findViewById<TextView>(R.id.text).text = days[tab.position]

                // Set the custom view for the selected tab
                tab.customView = customView
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Clear the custom view when the tab is unselected
                tab.customView = null
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle reselection of the tab if needed
                // Create a custom view for the selected tab
                val customView = LayoutInflater.from(requireContext())
                    .inflate(R.layout.time_table_custom_tab_layout, null)
                customView.findViewById<TextView>(R.id.text).text = days[tab.position]

                // Set the custom view for the selected tab
                tab.customView = customView
            }
        })


        if(getCurrentDayOfWeek() == 0){
            val customView = LayoutInflater.from(requireContext())
                .inflate(R.layout.time_table_custom_tab_layout, null)
            customView.findViewById<TextView>(R.id.text).text = days[0]
            binding.tabLayout.getTabAt(0)!!.customView = customView
        }
        else{
            binding.viewPager.currentItem = getCurrentDayOfWeek()
        }

        return binding.root

    }

    override fun onResume() {
        super.onResume()


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