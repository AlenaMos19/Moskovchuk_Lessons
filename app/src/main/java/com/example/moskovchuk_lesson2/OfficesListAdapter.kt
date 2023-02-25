package com.example.moskovchuk_lesson2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OfficesListAdapter (private val officesList : ArrayList<OfficeItem>): RecyclerView.Adapter<OfficesListAdapter.OfficesHolder>(){

    class OfficesHolder (item: View): RecyclerView.ViewHolder (item) {
        val offName = item.findViewById<TextView>(R.id.tv_office)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficesHolder {
        val layout = when (viewType) {
            TYPE_RU -> R.layout.item_office_ru
            TYPE_BY -> R.layout.item_office_by
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return OfficesHolder(view)
    }

    override fun getItemCount(): Int {
        return officesList.size
    }

    override fun onBindViewHolder(holder: OfficesHolder, position: Int) {
        val officeItem = officesList[position]
        holder.offName.text = officeItem.city
        holder.itemView.setOnClickListener{
            true
        }
    }
    override fun getItemViewType(position: Int): Int {
        val item = officesList[position]
        return if (item.type == "BY") {
            TYPE_BY
        } else {
            TYPE_RU
        }
    }
    companion object {
        const val TYPE_BY = 1
        const val TYPE_RU = -1
    }
}