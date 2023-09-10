package com.ihrsachin.apostle.screens.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ihrsachin.apostle.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class PictureAdapter(private val context : Context, private val dataList: List<Picture>) : RecyclerView.Adapter<PictureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_picture_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgUrl = dataList[position].imgUrl
        Picasso.get()
            .load(imgUrl)
            .into(holder.imageView)

//        holder.titleTextView.text = dataList[position].title
//        holder.descTextView.text = dataList[position].description
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.image_view)
        val titleTextView : TextView = itemView.findViewById(R.id.picture_title)
        val descTextView : TextView = itemView.findViewById(R.id.picture_description)
    }
}