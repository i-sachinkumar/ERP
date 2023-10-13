package com.ihrsachin.apostle.screens.attendance


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prolificinteractive.materialcalendarview.CalendarDay

class AttendanceViewModel: ViewModel(){


    // The current "present" percent
    private var _attendancePercent = MutableLiveData<Float>()
    val attendancePercent : LiveData<Float>
        get() = _attendancePercent


    //longest "present" streak
    private var _highestStreak = MutableLiveData<Int>()
    val highestStreak : LiveData<Int>
        get() = _highestStreak


    //current "present" streak
    private var _currStreak = MutableLiveData<Int>()
    val currStreak : LiveData<Int>
        get() = _currStreak



    // The month-wise "present"
    private var _presentDays = MutableLiveData<Map<Int, List<CalendarDay>>>()
    val presentDays : LiveData<Map<Int, List<CalendarDay>>>
        get() = _presentDays


    private var _isExpanded = MutableLiveData<Boolean>()
    val isExpanded : LiveData<Boolean>
        get() = _isExpanded


    init {
        _isExpanded.value = false
    }
    fun changeExpandStatus(status : Boolean) {
        _isExpanded.value = status
    }

}