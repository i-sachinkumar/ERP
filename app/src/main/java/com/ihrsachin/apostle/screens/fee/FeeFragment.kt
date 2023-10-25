package com.ihrsachin.apostle.screens.fee

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.FeeFragmentBinding
import com.ihrsachin.apostle.screens.time_table.TimeTablePagerAdapter
import java.util.Calendar


class FeeFragment : Fragment() {

    private lateinit var binding: FeeFragmentBinding
    private lateinit var viewModel: FeeViewModel

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private val months = arrayListOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        //return super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fee_fragment,
            container,
            false
        )


        // Set the adapter for ViewPager2
        binding.viewPager.adapter = MonthPagerAdapter(this, months)


        // Connect the TabLayout with the ViewPager2
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = months[position]
        }.attach()



        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // Create a custom view for the selected tab
                val customView = LayoutInflater.from(requireContext())
                    .inflate(R.layout.time_table_custom_tab_layout, null)
                customView.findViewById<TextView>(R.id.text).text = months[tab.position]

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
                customView.findViewById<TextView>(R.id.text).text = months[tab.position]

                // Set the custom view for the selected tab
                tab.customView = customView
            }
        })


        if(getCurrentMonth() == 0){
            val customView = LayoutInflater.from(requireContext())
                .inflate(R.layout.time_table_custom_tab_layout, null)
            customView.findViewById<TextView>(R.id.text).text = months[0]
            binding.tabLayout.getTabAt(0)!!.customView = customView
        }
        else{
            binding.viewPager.currentItem = getCurrentMonth()
        }

        return binding.root
    }


    private fun getCurrentMonth() : Int{
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.MONTH)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.feePage = this
    }



}