package com.example.moskovchuk_lesson2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moskovchuk_lesson2.databinding.FragmentAuthorizationBinding
import com.example.moskovchuk_lesson2.databinding.FragmentVacanciesBinding

class VacanciesFragment : Fragment() {

    lateinit var binding: FragmentVacanciesBinding

    private lateinit var vacancyAdapter: VacanciesListAdapter
    private lateinit var recyclerViewVac: RecyclerView
    private lateinit var vacancyArrayList: ArrayList<VacancyItem>

    lateinit var vacancyName: Array<String>
    lateinit var vacancySalary: Array<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVacanciesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerViewVac = view.findViewById(R.id.rv_list_vacancies)
        recyclerViewVac.layoutManager = layoutManager
        recyclerViewVac.setHasFixedSize(true)
        vacancyAdapter = VacanciesListAdapter(vacancyArrayList)
        recyclerViewVac.adapter = vacancyAdapter
    }

    private fun dataInitialize(){

        vacancyArrayList = arrayListOf<VacancyItem>()

        vacancyName = arrayOf(
            getString(R.string.vacancy_and_jun),
            getString(R.string.vacancy_and_mid),
            getString(R.string.vacancy_and_sen),
            getString(R.string.vacancy_and_lead),
            getString(R.string.vacancy_java_jun),
            getString(R.string.vacancy_java_mid),
            getString(R.string.vacancy_java_sen),
            getString(R.string.vacancy_java_lead),
            getString(R.string.vacancy_ios_jun),
            getString(R.string.vacancy_ios_mid),
            getString(R.string.vacancy_ios_sen),
            getString(R.string.vacancy_ios_lead),
            getString(R.string.vacancy_pit_jun),
            getString(R.string.vacancy_pit_mid),
            getString(R.string.vacancy_pit_sen),
            getString(R.string.vacancy_pit_lead),
            getString(R.string.vacancy_qa_jun),
            getString(R.string.vacancy_qa_mid),
            getString(R.string.vacancy_qa_sen),
            getString(R.string.vacancy_qa_lead)
        )

        vacancySalary = arrayOf(
            getString(R.string.salary_jun),
            getString(R.string.salary_mid),
            getString(R.string.salary_sen),
            getString(R.string.salary_lead),
            getString(R.string.salary_jun),
            getString(R.string.salary_mid),
            getString(R.string.salary_sen),
            getString(R.string.salary_lead),
            getString(R.string.salary_jun),
            getString(R.string.salary_mid),
            getString(R.string.salary_sen),
            getString(R.string.salary_lead),
            getString(R.string.salary_jun),
            getString(R.string.salary_mid),
            getString(R.string.salary_sen),
            getString(R.string.salary_lead),
            getString(R.string.salary_jun),
            getString(R.string.salary_mid),
            getString(R.string.salary_sen),
            getString(R.string.salary_lead),
        )

        for (i in vacancyName.indices){
            val vacancy = VacancyItem(vacancyName[i], vacancySalary[i])
            vacancyArrayList.add(vacancy)
        }
    }

    companion object{

        fun newInstance() = VacanciesFragment()
    }
}