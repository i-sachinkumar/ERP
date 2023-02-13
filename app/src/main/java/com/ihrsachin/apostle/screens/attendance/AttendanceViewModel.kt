package com.ihrsachin.apostle.screens.attendance


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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

    //true if present today
    var isPresentToday = MutableLiveData<Boolean>()

    var isHolyDayToday = MutableLiveData<Boolean>()

}