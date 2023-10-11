package com.ihrsachin.apostle.screens.time_table

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.model.Period

class PeriodAdapter(private val itemList: List<Period>) : RecyclerView.Adapter<PeriodAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subject: TextView = itemView.findViewById(R.id.subject)
        val timing: TextView = itemView.findViewById(R.id.timing)
        val teacher: TextView = itemView.findViewById(R.id.teacher)
        val period : TextView = itemView.findViewById(R.id.period)
        val line : View = itemView.findViewById(R.id.view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.time_table_item_fragment_item2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        holder.subject.text = item.subject
        holder.timing.text = "${item.startTime} - ${item.endTime}"


        if(item.isBreak){
            holder.teacher.visibility = GONE
            holder.period.visibility = GONE
            holder.line.visibility = GONE
            holder.timing.setTextColor(Color.WHITE)
            val itemview = holder.itemView as MaterialCardView
            itemview.setCardBackgroundColor(Color.parseColor("#4871C3"))
        }
        else{
            holder.teacher.visibility = VISIBLE
            holder.period.visibility = VISIBLE
            holder.line.visibility = VISIBLE
            holder.teacher.text = item.teacher
            holder.period.text = "Period${item.periodNum}"
            holder.timing.setTextColor(Color.parseColor("#888888"))
            val itemview = holder.itemView as MaterialCardView
            itemview.setBackgroundColor(Color.WHITE)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
