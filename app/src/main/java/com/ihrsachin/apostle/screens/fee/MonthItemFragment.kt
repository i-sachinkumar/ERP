package com.ihrsachin.apostle.screens.fee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.FeeMonthItemFragmentBinding
import com.ihrsachin.apostle.sample_data.FeeData
import com.ihrsachin.apostle.screens.time_table.PeriodAdapter

class MonthItemFragment : Fragment() {

    private lateinit var binding : FeeMonthItemFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fee_month_item_fragment, container, false)

        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = FeeAdapter(requireContext(), FeeData.getData())

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        return binding.root
    }
}