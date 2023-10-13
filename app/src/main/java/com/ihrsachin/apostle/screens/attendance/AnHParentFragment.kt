package com.ihrsachin.apostle.screens.attendance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.AttendanceNHolidayParentFragmentBinding

class AnHParentFragment : Fragment() {

    private lateinit var binding : AttendanceNHolidayParentFragmentBinding

    private val sections = arrayListOf("Attendance", "Holidays")

    private lateinit var customView : View
    private lateinit var tabTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.attendance_n_holiday_parent_fragment, container, false)

        customView = LayoutInflater.from(requireContext())
            .inflate(R.layout.att_n_h_tab_item, null)
        tabTextView = customView.findViewById(R.id.text)

        // Set the adapter for ViewPager2
        binding.viewPager.adapter = AnHParentPagerAdapter(this, sections)


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
            tab.text = sections[position]
        }.attach()


        binding.viewPager.isUserInputEnabled = false

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

                tabTextView.text = sections[tab.position]
                // Set the custom view for the selected tab
                tab.customView = customView
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Clear the custom view when the tab is unselected
                tab.customView = null
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                tabTextView.text = sections[tab.position]
                // Set the custom view for the selected tab
                tab.customView = customView
            }
        })


        binding.viewPager.currentItem = 1
        binding.viewPager.currentItem = 0

        return binding.root
    }
}