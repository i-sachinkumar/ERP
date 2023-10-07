package com.ihrsachin.apostle.screens.time_table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.TimeTableItemFragmentBinding


class TimeTableItemFragment : Fragment() {

    lateinit var binding : TimeTableItemFragmentBinding
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.time_table_item_fragment, container, false)

        // Get the string from the arguments
        val stringToShow = requireArguments().getString("string")


        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager

        val rows = listOf("Period 1", "Period 2", "Period 3", "Period 4", "Period 5", "Period 6", "Period 7", "Period 8")
        val columns = listOf(rows, rows, rows, rows, rows, rows, rows)
        val adapter = ColumnAdapter(requireContext(), columns)
        binding.recyclerView.adapter = adapter

        return binding.root
    }
}
