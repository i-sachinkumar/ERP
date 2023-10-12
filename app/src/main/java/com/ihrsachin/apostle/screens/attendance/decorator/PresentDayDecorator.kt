package com.ihrsachin.apostle.screens.attendance.decorator

import android.content.Context
import com.ihrsachin.apostle.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

class PresentDayDecorator(private val presentDays: List<CalendarDay>, private val context : Context): DayViewDecorator {

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return presentDays.contains(day)
    }

    override fun decorate(view: DayViewFacade?) {
        view!!.setBackgroundDrawable(context.resources.getDrawable(R.drawable.present_day_bg))
    }
}