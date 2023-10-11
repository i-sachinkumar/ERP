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
import com.ihrsachin.apostle.databinding.TimeTableItemFragment2Binding
import com.ihrsachin.apostle.databinding.TimeTableItemFragmentBinding
import com.ihrsachin.apostle.model.Period
import java.sql.Time
import javax.security.auth.Subject


class TimeTableItemFragment : Fragment() {

    //old fragment, not being used
//    lateinit var binding : TimeTableItemFragmentBinding

    // new, currently in use
    lateinit var binding : TimeTableItemFragment2Binding
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?,
    ): View? {

        //it was old style, not used anymore
//        return oldView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.time_table_item_fragment2, container, false)


        val itemList = listOf(
            Period(teacher = "Rama Pal", startTime = "9:00am", endTime = "9:45am", subject = "Computer Science", periodNum = 1),
            Period(teacher = "Rama Pal", startTime = "9:00am", endTime = "9:45am", subject = "Computer Science", periodNum = 2),
            Period(teacher = "Rama Pal", startTime = "9:00am", endTime = "9:45am", subject = "Computer Science", periodNum = 3),
            Period(teacher = "Rama Pal", startTime = "9:00am", endTime = "9:45am", subject = "Computer Science", periodNum = 4),
            Period(isBreak = true, startTime = "9:00am", endTime = "9:45am", breakName = "Lunch"),
            Period(teacher = "Rama Pal", startTime = "9:00am", endTime = "9:45am", subject = "Computer Science", periodNum = 5),
            Period(teacher = "Rama Pal", startTime = "9:00am", endTime = "9:45am", subject = "Computer Science", periodNum = 6),
            Period(teacher = "Rama Pal", startTime = "9:00am", endTime = "9:45am", subject = "Computer Science", periodNum = 7),
            Period(teacher = "Rama Pal", startTime = "9:00am", endTime = "9:45am", subject = "Computer Science", periodNum = 8),

        )

        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = PeriodAdapter(itemList)

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        return binding.root
    }

//    fun oldView(inflater: LayoutInflater,
//                @Nullable container: ViewGroup?,
//                @Nullable savedInstanceState: Bundle?,
//                ) : View?{
//        binding = DataBindingUtil.inflate(inflater, R.layout.time_table_item_fragment, container, false)
//
//        // Get the string from the arguments
//        val stringToShow = requireArguments().getString("string")
//
//
//        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//        binding.recyclerView.layoutManager = layoutManager
//
//        val periods = listOf("Period 1", "Period 2", "Period 3", "Period 4", "Period 5", "Period 6", "Period 7", "Period 8")
//
//        val startTime = listOf("Starts at", "08:30 AM", "09:30 AM","10:30 AM", "11:30 AM", "12:30 PM", "01:30 PM", "02:30 PM", "3:30 PM")
//
//        val endTime = listOf("Ends At", "09:25 AM","10:25 AM", "11:25 AM", "12:25 PM", "01:25 PM", "02:25 PM", "3:25 PM", "2:25 PM")
//
//        val subject = listOf("Subject", "Subject 1", "Subject 2", "Subject 3", "Subject 4", "Subject 5", "Subject 6", "Subject 7", "Subject 8")
//
//        val teacherName = listOf("Teacher", "Teacher 1", "Teacher 2", "Teacher 3", "Teacher 4", "Teacher 5", "Teacher 6", "Teacher 7", "Teacher 8")
//
//        val columns = listOf(startTime, endTime, subject, teacherName )
//        val adapter = ColumnAdapter(requireContext(), columns)
//        binding.recyclerView.adapter = adapter
//
//        return binding.root
//    }
}
