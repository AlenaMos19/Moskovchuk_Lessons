package com.example.moskovchuk_lesson2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moskovchuk_lesson2.databinding.FragmentOfficeMinskBinding
import com.example.moskovchuk_lesson2.databinding.FragmentVacanciesBinding


class OfficeFragmentMinsk : Fragment() {

    lateinit var binding: FragmentOfficeMinskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOfficeMinskBinding.inflate(inflater)
        return binding.root
    }

    companion object{

        fun newInstance() = OfficeFragmentMinsk()
    }
}