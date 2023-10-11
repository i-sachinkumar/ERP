package com.ihrsachin.apostle.screens.date_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.DateSheetFragmentBinding
import com.ihrsachin.apostle.model.DateSheetItem


class DateSheetFragment : Fragment() {

    private lateinit var binding: DateSheetFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.date_sheet_fragment, container, false)


        val itemList = listOf(
            DateSheetItem(
                subject = "English",
                dateDayDD = "11",
                dateMonth = "JAN",
                dateWeekDay = "Friday",
                startTime = "09:30 AM",
                endTime = "12:30 PM"
            ),
            DateSheetItem(
                subject = "English",
                dateDayDD = "11",
                dateMonth = "JAN",
                dateWeekDay = "Friday",
                startTime = "09:30 AM",
                endTime = "12:30 PM"
            ),
            DateSheetItem(
                subject = "English",
                dateDayDD = "11",
                dateMonth = "JAN",
                dateWeekDay = "Friday",
                startTime = "09:30 AM",
                endTime = "12:30 PM"
            ),
            DateSheetItem(
                subject = "English",
                dateDayDD = "11",
                dateMonth = "JAN",
                dateWeekDay = "Friday",
                startTime = "09:30 AM",
                endTime = "12:30 PM"
            ),
            DateSheetItem(
                subject = "English",
                dateDayDD = "11",
                dateMonth = "JAN",
                dateWeekDay = "Friday",
                startTime = "09:30 AM",
                endTime = "12:30 PM"
            ),
            DateSheetItem(
                subject = "English",
                dateDayDD = "11",
                dateMonth = "JAN",
                dateWeekDay = "Friday",
                startTime = "09:30 AM",
                endTime = "12:30 PM"
            ),
            DateSheetItem(
                subject = "English",
                dateDayDD = "11",
                dateMonth = "JAN",
                dateWeekDay = "Friday",
                startTime = "09:30 AM",
                endTime = "12:30 PM"
            ),
            DateSheetItem(
                subject = "English",
                dateDayDD = "11",
                dateMonth = "JAN",
                dateWeekDay = "Friday",
                startTime = "09:30 AM",
                endTime = "12:30 PM"
            ),
            DateSheetItem(
                subject = "English",
                dateDayDD = "11",
                dateMonth = "JAN",
                dateWeekDay = "Friday",
                startTime = "09:30 AM",
                endTime = "12:30 PM"
            ),
            DateSheetItem(
                subject = "English",
                dateDayDD = "11",
                dateMonth = "JAN",
                dateWeekDay = "Friday",
                startTime = "09:30 AM",
                endTime = "12:30 PM"
            ),
        )

        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = DateSheetAdapter(itemList)

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter


        return binding.root
    }
}