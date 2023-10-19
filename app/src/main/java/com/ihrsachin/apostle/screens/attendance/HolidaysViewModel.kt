package com.ihrsachin.apostle.screens.attendance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prolificinteractive.materialcalendarview.CalendarDay


class HolidaysViewModel : ViewModel() {

    private val _holidays: MutableMap<Int, List<CalendarDay>>
    val holidays: Map<Int, List<CalendarDay>>
        get() = _holidays


    init {
        _holidays = createHolidaysMap()
    }

    private fun createHolidaysMap(): MutableMap<Int, List<CalendarDay>> {
        // Implement your logic to populate the holidays map here
        val holidaysMap = mutableMapOf<Int, List<CalendarDay>>()

        // For example, you can add some sample data
        holidaysMap[11] = listOf(
            CalendarDay.from(2023, 11, 1),
            CalendarDay.from(2023, 11, 25)
            // Add more holiday dates as needed
        )
        return holidaysMap
    }
}