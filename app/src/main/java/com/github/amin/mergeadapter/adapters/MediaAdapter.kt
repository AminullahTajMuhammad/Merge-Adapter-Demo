package com.github.amin.mergeadapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.amin.mergeadapter.R
import com.github.amin.mergeadapter.models.MediaModel

class MediaAdapter(var context: Context): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_media, parent, false))
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        setupImageRecyclerView(holder)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val images_recycler = itemView.findViewById<RecyclerView>(R.id.images_recycler)
        var imagesAdapter : ImagesAdapter? = null
    }

    private fun setupImageRecyclerView(holder: ViewHolder) {
        holder.imagesAdapter = ImagesAdapter(context)
        val list = arrayListOf<MediaModel>()
        list.add(MediaModel(R.drawable.one))
        list.add(MediaModel(R.drawable.two))
        list.add(MediaModel(R.drawable.three))
        list.add(MediaModel(R.drawable.one))
        list.add(MediaModel(R.drawable.two))
        list.add(MediaModel(R.drawable.three))
        list.add(MediaModel(R.drawable.two))

        holder.imagesAdapter?.addData(list)
        holder.images_recycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            adapter = holder.imagesAdapter
        }
        holder.imagesAdapter?.notifyDataSetChanged()
    }
}