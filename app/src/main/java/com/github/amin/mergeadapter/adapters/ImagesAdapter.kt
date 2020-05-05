package com.github.amin.mergeadapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.github.amin.mergeadapter.R
import com.github.amin.mergeadapter.models.MediaModel

class ImagesAdapter(var context: Context) : RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {

    var list = arrayListOf<MediaModel>()

    fun addData(newList: ArrayList<MediaModel>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_media_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.media_item.setImageResource(list[position].img)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val media_item = itemView.findViewById<AppCompatImageView>(R.id.media_item)
    }

}