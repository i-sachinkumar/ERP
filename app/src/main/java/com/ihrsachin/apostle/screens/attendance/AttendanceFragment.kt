package com.ihrsachin.apostle.screens.attendance

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.AttendanceFragmentBinding

class AttendanceFragment: Fragment() {
    private lateinit var binding: AttendanceFragmentBinding
    private lateinit var viewModel: AttendanceViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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


        // Create a list of PieEntries with values and labels
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(27f, "Present"))
        entries.add(PieEntry(15f, "Absent"))

        // Create a PieDataSet
        val dataSet = PieDataSet(entries, "")
        dataSet.colors = mutableListOf(Color.rgb(40, 128,40), Color.rgb(255, 40, 40)) // You can set custom colors here if needed
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


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.attendancePage = this
    }

}