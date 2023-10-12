package com.ihrsachin.apostle.screens.attendance.decorator

import android.content.Context
import com.ihrsachin.apostle.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

class CurrentDayDecorator(private val currentDay: CalendarDay, private val context : Context): DayViewDecorator {

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return this.currentDay == day
    }

    override fun decorate(view: DayViewFacade?) {
        view!!.setBackgroundDrawable(context.resources.getDrawable(R.drawable.current_day_bg))
    }
}