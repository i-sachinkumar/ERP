package com.ihrsachin.apostle.screens.date_sheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.model.DateSheetItem

class DateSheetAdapter(private val itemList: List<DateSheetItem>) :
    RecyclerView.Adapter<DateSheetAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subject: TextView = itemView.findViewById(R.id.subject)
        val timing: TextView = itemView.findViewById(R.id.timing)
        val dateDayDD: TextView = itemView.findViewById(R.id.date_day)
        val dateMonth: TextView = itemView.findViewById(R.id.date_month)
        val dateWeekDay: TextView = itemView.findViewById(R.id.date_week_day)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.date_sheet_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        holder.subject.text = item.subject
        holder.timing.text = "${item.startTime} - ${item.endTime}"
        holder.dateDayDD.text = item.dateDayDD
        holder.dateMonth.text = item.dateMonth
        holder.dateWeekDay.text = item.dateWeekDay
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
