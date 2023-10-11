package com.ihrsachin.apostle.model

import java.lang.Exception

class Period{
    val isBreak : Boolean
    val teacher: String
    val startTime: String
    val periodNum: Int
    val subject: String
    val endTime: String

    constructor(teacher: String,
                startTime: String,
                periodNum: Int,
                subject: String,
                endTime: String){
        this.teacher = teacher
        this.subject = subject
        this.startTime = startTime
        this.endTime = endTime
        this.periodNum = periodNum
        this.isBreak = false
    }

    constructor(isBreak : Boolean,
                startTime: String,
                breakName: String,
                endTime: String){
        if(!isBreak){
            throw Exception("Bad arguments passed: teacher and periodNum must be passed")
        }
        this.isBreak = true
        this.startTime = startTime
        this.endTime = endTime
        this.subject = breakName
        this.teacher = ""
        this.periodNum = -1
    }
}