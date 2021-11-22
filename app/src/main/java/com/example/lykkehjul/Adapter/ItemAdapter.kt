package com.example.lykkehjul.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lykkehjul.Model.Ord
import com.example.lykkehjul.R

class ItemAdapter(val data: List<Ord>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    val item: List<Ord>

    init {
        this.item = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = data[position].ord
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder
    internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
    }


}

















