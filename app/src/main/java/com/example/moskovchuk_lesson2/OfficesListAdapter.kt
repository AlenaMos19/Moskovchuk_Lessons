package com.example.moskovchuk_lesson2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class OfficesListAdapter (private val officesList : ArrayList<OfficeItem>): RecyclerView.Adapter<OfficesListAdapter.OfficesHolder>(){

//    var onItemClickListener: ((OfficeItem) -> Unit)? = null

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener
    }

    class OfficesHolder (item: View, listener: onItemClickListener): RecyclerView.ViewHolder (item) {

        val offName = item.findViewById<TextView>(R.id.tv_office)

        init {
            item.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficesHolder {

        val layout = when (viewType) {
            TYPE_RU -> R.layout.item_office_ru
            TYPE_BY -> R.layout.item_office_by
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
   //     val viewHolder = OfficesHolder(view)
  //      viewHolder.itemView.setOnClickListener {
 //           onItemClickListener?.invoke(officesList[viewHolder.adapterPosition])
 //       }
        return OfficesHolder(view, mListener)
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

 //       holder.itemView.setOnClickListener(object : View.OnClickListener{

        //override fun onClick(v: View?) {

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
