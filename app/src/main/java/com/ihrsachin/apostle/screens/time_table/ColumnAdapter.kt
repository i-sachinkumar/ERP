package com.ihrsachin.apostle.screens.time_table

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.ihrsachin.apostle.R

class ColumnAdapter(private val context: Context, private val columns: List<List<String>>) :
    RecyclerView.Adapter<ColumnAdapter.ColumnViewHolder>() {
    class ColumnViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val columnTableLayout : TableLayout = itemView.findViewById(R.id.column_table_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColumnViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.time_table_item_fragment_item, parent, false)
        return ColumnViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return columns.size
    }

    override fun onBindViewHolder(holder: ColumnViewHolder, position: Int) {
        val rows : List<String> = columns[position]

        for(i in rows.indices) {
            val row = holder.columnTableLayout[i] as TextView
            row.text = rows[i]
        }
    }
}