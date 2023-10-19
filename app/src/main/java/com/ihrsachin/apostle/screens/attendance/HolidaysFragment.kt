package com.ihrsachin.apostle.screens.attendance

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.animation_utils.ToggleAnimation
import com.ihrsachin.apostle.databinding.HolidaysFragmentBinding
import com.ihrsachin.apostle.screens.attendance.decorator.AbsentDayDecorator
import com.ihrsachin.apostle.screens.attendance.decorator.CurrentDayDecorator
import com.ihrsachin.apostle.screens.attendance.decorator.PresentDayDecorator
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.time.LocalDate
import kotlin.math.roundToInt
import kotlin.properties.Delegates


class HolidaysFragment : Fragment() {

    private lateinit var binding: HolidaysFragmentBinding
    private lateinit var viewModel: HolidaysViewModel

    private lateinit var currentDay: CalendarDay

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.holidays_fragment, container, false)

        viewModel = ViewModelProvider(this)[HolidaysViewModel::class.java]

        // will adjust position depending on screen size and the content height
        adjustBottomDesign()

        setupCalenderView()

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupCalenderView() {
        currentDay = CalendarDay.from(
            LocalDate.now().year,
            LocalDate.now().monthValue,
            LocalDate.now().dayOfMonth
        )

        binding.calenderView.state().edit()
//            .setMinimumDate(CalendarDay.from(2016, 4, 3))
//            .setMaximumDate(CalendarDay.from(2030, 5, 12))
            .setCalendarDisplayMode(CalendarMode.MONTHS)
            .commit()
        // will show some dates of next and previous months in light color
        binding.calenderView.showOtherDates = MaterialCalendarView.SHOW_OTHER_MONTHS


        // color change on date based on different status
//        binding.calenderView.addDecorator(
//            PresentDayDecorator(presentDays = viewModel.holidays., requireContext())
//        )


        // On click listener
        binding.calenderView.setOnDateChangedListener { widget: MaterialCalendarView, day: CalendarDay, isSelected: Boolean ->
            onDateClicked(widget, day, isSelected)
        }




        binding.calenderView.setOnMonthChangedListener { widget: MaterialCalendarView, day: CalendarDay ->

            binding.holidaysList.removeAllViews()
            var emptyView = View(requireContext())
            emptyView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(requireContext(),20))
            // Add the empty View to the LinearLayout
            binding.holidaysList.addView(emptyView)



            val monthCode = day.month

            val holidays = viewModel.holidays[monthCode]
            if (holidays != null) {
                // show green color holidays
                binding.calenderView.addDecorator(
                    PresentDayDecorator(
                        presentDays = viewModel.holidays[monthCode]!!,
                        requireContext()
                    )
                )


                val layoutInflater =
                    LayoutInflater.from(context) // You can pass the context of your activity or fragment here


                for (holiday in holidays){
                    // Inflate the layout resource into a View
                    val inflatedView = layoutInflater.inflate(R.layout.holidays_list_item, null)
                    val holidayTitle : TextView = inflatedView.findViewById(R.id.holiday_title)
                    val holidayDate : TextView = inflatedView.findViewById(R.id.holiday_date)
                    val holidayDay : TextView = inflatedView.findViewById(R.id.holiday_day)
                    holidayTitle.text = "Holiday ${holiday.day}"
                    binding.holidaysList.addView(inflatedView)
                    emptyView = View(requireContext())
                    emptyView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(requireContext(),20))
                    binding.holidaysList.addView(emptyView)
                }
            }

            adjustBottomDesign()
        }
    }

    private fun onDateClicked(
        widget: MaterialCalendarView,
        day: CalendarDay,
        isSelected: Boolean
    ): Unit {
//        holidaySelected(day)
    }

    private fun holidaySelected(day: CalendarDay){
        val monthCode = day.month

        val holidays = viewModel.holidays[monthCode]
        if (holidays != null && holidays.contains(day)) {
            val index = holidays.indexOf(day)
            val item = binding.holidaysList[index]
            item.setBackgroundColor(Color.GREEN)
        }
    }


    private fun adjustBottomDesign() {
        val params = binding.bottomDesign.layoutParams as ViewGroup.MarginLayoutParams
        params.topMargin = dpToPx(requireContext(), 20)
        binding.bottomDesign.layoutParams = params

        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeight = displayMetrics.heightPixels
        val tabLayoutHeight = dpToPx(requireContext(), 50)

        println("sc : $screenHeight, t: $tabLayoutHeight")

        val parentLayout = binding.parent  // Reference to your ConstraintLayout

        parentLayout.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                // Remove the listener to avoid multiple calls
                parentLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)

                // Get the accurate height of the parentLayout
                val parentHeightWithBottom = parentLayout.height

                if (tabLayoutHeight + parentHeightWithBottom >= screenHeight) {
                    // Your condition if the layout exceeds the screen height
                } else {
                    val params = binding.bottomDesign.layoutParams as ViewGroup.MarginLayoutParams
                    params.topMargin = screenHeight - parentHeightWithBottom - tabLayoutHeight
                    binding.bottomDesign.layoutParams = params
                }
            }
        })
    }

    private fun dpToPx(context: Context, dp: Int): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density).roundToInt()
    }
}