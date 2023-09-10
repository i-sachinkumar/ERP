package com.ihrsachin.apostle.screens.time_table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.ihrsachin.apostle.MainActivity
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.TimeTableFragmentBinding

class TimeTableFragment : Fragment(){

    private lateinit var binding : TimeTableFragmentBinding
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

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(requireActivity(), "${tab!!.text} is selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(requireActivity(), "${tab!!.text} is re-selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(requireActivity(), "${tab!!.text} is un-selected", Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root

    }
}