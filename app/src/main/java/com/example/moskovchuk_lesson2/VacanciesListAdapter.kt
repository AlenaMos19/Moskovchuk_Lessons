package com.example.moskovchuk_lesson2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VacanciesListAdapter(private val vacanciesList : ArrayList<VacancyItem>): RecyclerView.Adapter<VacanciesListAdapter.VacanciesHolder>() {

    class VacanciesHolder (item: View): RecyclerView.ViewHolder (item) {
        val vacName = item.findViewById<TextView>(R.id.tv_vacancy_name)
        val vacSalary = item.findViewById<TextView>(R.id.tv_salary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacanciesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vacancy, parent, false)
        return VacanciesHolder(view)
    }

    override fun getItemCount(): Int {
        return vacanciesList.size
    }

    override fun onBindViewHolder(holder: VacanciesHolder, position: Int) {
        val vacancyItem = vacanciesList[position]
        holder.vacName.text = vacancyItem.name
        holder.vacSalary.text = vacancyItem.salary
        holder.itemView.setOnClickListener{
            true
        }
    }
}