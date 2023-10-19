package com.ihrsachin.apostle.screens.attendance


import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.animation_utils.ToggleAnimation
import com.ihrsachin.apostle.databinding.AttendanceFragmentBinding
import com.ihrsachin.apostle.screens.attendance.decorator.AbsentDayDecorator
import com.ihrsachin.apostle.screens.attendance.decorator.CurrentDayDecorator
import com.ihrsachin.apostle.screens.attendance.decorator.PresentDayDecorator
import com.ihrsachin.apostle.screens.homepage.HomePageViewModel
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.MaterialCalendarView.SHOW_OTHER_MONTHS
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener
import java.time.LocalDate


class AttendanceFragment : Fragment() {

    private lateinit var binding: AttendanceFragmentBinding
    private lateinit var viewModel: AttendanceViewModel

    private lateinit var currentDay : CalendarDay

    private lateinit var greenDays : List<CalendarDay>
    private lateinit var redDays : List<CalendarDay>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.attendance_fragment,
            container,
            false
        )

        viewModel =ViewModelProvider(this)[AttendanceViewModel::class.java]

        currentDay = CalendarDay.from(LocalDate.now().year, LocalDate.now().monthValue, LocalDate.now().dayOfMonth)
        greenDays = listOf(CalendarDay.from(2023, 10, 3), CalendarDay.from(2023, 10, 4))
        redDays = listOf(CalendarDay.from(2023, 10, 5), CalendarDay.from(2023, 10, 6))



        // Create a list of PieEntries with values and labels
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(27f, "Present"))
        entries.add(PieEntry(15f, "Absent"))

        // Create a PieDataSet
        val dataSet = PieDataSet(entries, "")
        dataSet.colors = mutableListOf(
            Color.rgb(40, 128, 40),
            Color.rgb(255, 40, 40)
        ) // You can set custom colors here if needed
        dataSet.valueTextColor = Color.BLUE
        dataSet.valueTextSize = 18f
        dataSet.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                val absoluteValue = value.toInt()
                return "$absoluteValue"
            }
        }

        // Create a PieData object
        val data = PieData(dataSet)

        // Set up the pie chart
        binding.pieChart.let {
            it.data = data
            it.centerText = "Attendance"
            it.description.isEnabled = false
            it.setUsePercentValues(false)
            it.animateY(1500, Easing.EaseInOutQuad)
        }

        // Refresh the chart
        binding.pieChart.invalidate()



        //calendar

        binding.calenderView.state().edit()
//            .setMinimumDate(CalendarDay.from(2016, 4, 3))
//            .setMaximumDate(CalendarDay.from(2030, 5, 12))
            .setCalendarDisplayMode(CalendarMode.MONTHS)
            .commit()
        // will show some dates of next and previous months in light color
        binding.calenderView.showOtherDates = SHOW_OTHER_MONTHS


        // color change on date based on different status
        binding.calenderView.addDecorators(
            CurrentDayDecorator(currentDay = currentDay, requireContext()),
            PresentDayDecorator(presentDays = greenDays, requireContext()),
            AbsentDayDecorator(absentDays = redDays, requireContext())
        )


        // On click listener
        binding.calenderView.setOnDateChangedListener { widget: MaterialCalendarView, day: CalendarDay, isSelected: Boolean ->
            listener(widget, day, isSelected)
        }


        // collapsing the events list view.. can be expanded by clicking no dates
        ToggleAnimation(binding.eventList).collapse()
        viewModel.changeExpandStatus(false)


        binding.calenderView.setOnMonthChangedListener{ widget: MaterialCalendarView, day: CalendarDay ->
            ToggleAnimation(binding.eventList).collapse()
            viewModel.changeExpandStatus(false)
        }

        return binding.root
    }

    fun listener(widget : MaterialCalendarView, day : CalendarDay, isSelected: Boolean) : Unit{
        Toast.makeText(requireContext(), "$day", Toast.LENGTH_SHORT).show()
         if(!viewModel.isExpanded.value!!){
             ToggleAnimation(binding.eventList).expand()
             viewModel.changeExpandStatus(true)
         }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.attendancePage = this
    }



}