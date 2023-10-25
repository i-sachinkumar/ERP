package com.ihrsachin.apostle.screens.fee

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.model.Fee

class FeeAdapter(private val context: Context, private val feeList: List<Fee>) : RecyclerView.Adapter<FeeAdapter.FeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fee_item, parent, false)
        return FeeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return feeList.size
    }

    override fun onBindViewHolder(holder: FeeViewHolder, position: Int) {
        val fee = feeList[position]

        holder.feeTypeTextView.text = fee.feeType
        holder.feeValueTextView.text = fee.feeValue.toString()

        if(fee.feeType == "Total Due"){
            holder.itemView.background =  context.resources.getDrawable(R.drawable.total_fee_bg)
            holder.feeTypeTextView.setTextColor(Color.WHITE)
        }
        else{
            holder.itemView.background =  null
            holder.feeTypeTextView.setTextColor(context.resources.getColor(R.color.time_table_gray))
        }
    }

    inner class FeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val feeTypeTextView: TextView = itemView.findViewById(R.id.fee_type)
        val feeValueTextView: TextView = itemView.findViewById(R.id.fee_value)
    }
}
