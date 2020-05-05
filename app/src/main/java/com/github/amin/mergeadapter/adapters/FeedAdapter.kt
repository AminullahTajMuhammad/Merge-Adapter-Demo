package com.github.amin.mergeadapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.github.amin.mergeadapter.R
import com.github.amin.mergeadapter.models.FeedModel
import de.hdodenhof.circleimageview.CircleImageView

class FeedAdapter(var context: Context, var list: ArrayList<FeedModel>): RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_feed, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.username.text = list[position].username
        holder.img_avatar.setImageResource(list[position].avatar)
        holder.image_feed.setImageResource(list[position].image)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_avatar = itemView.findViewById<CircleImageView>(R.id.img_avatar)
        val username = itemView.findViewById<AppCompatTextView>(R.id.tv_username)
        val image_feed = itemView.findViewById<AppCompatImageView>(R.id.image_feed)
    }
}