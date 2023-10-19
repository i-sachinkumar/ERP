package com.ihrsachin.apostle.screens.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.model.Event
import com.squareup.picasso.Picasso

class EventAdapter(private val dataList: List<Event>) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val eventImg: ImageView = itemView.findViewById(R.id.event_img)
        val timing: TextView = itemView.findViewById(R.id.timing)
        val description: TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.event_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = dataList[position]
        holder.title.text = event.title
        holder.timing.text = event.timing
        holder.description.text = event.description

        // Load the event image using Picasso or any other image loading library
        Picasso.get().load(event.imgUrl).into(holder.eventImg)
    }

    override fun getItemCount() = dataList.size
}