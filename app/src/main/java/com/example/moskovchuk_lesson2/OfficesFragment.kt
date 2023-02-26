package com.example.moskovchuk_lesson2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moskovchuk_lesson2.databinding.FragmentAuthorizationBinding
import com.example.moskovchuk_lesson2.databinding.FragmentOfficesBinding

class OfficesFragment : Fragment() {

    private lateinit var officeAdapter: OfficesListAdapter
    private lateinit var recyclerViewOff: RecyclerView
    private lateinit var officeArrayList: ArrayList<OfficeItem>

    lateinit var officeAddress: Array<String>
    lateinit var officeType: Array<String>

    lateinit var binding: FragmentOfficesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOfficesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        setupClickListener()
        val layoutManager = LinearLayoutManager(context)
        recyclerViewOff = view.findViewById(R.id.rv_list_offices)
        recyclerViewOff.layoutManager = layoutManager
        recyclerViewOff.setHasFixedSize(true)

    }

    private fun setupClickListener() {

        var offAdapter = OfficesListAdapter(officeArrayList)
        recyclerViewOff.adapter = offAdapter

        offAdapter.setOnItemClickListener(object : OfficesListAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when (position){
                    1 -> openFragment(OfficeFragmentMoscow.newInstance())
                    2 ->openFragment(OfficeFragmentMinsk.newInstance())
                }
            }
        })
    }

    private fun openFragment(f: Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container, f)
            .addToBackStack(null)
            .commit()
    }

    private fun dataInitialize() {

        officeArrayList = arrayListOf<OfficeItem>()

        officeAddress = arrayOf(
            getString(R.string.office_Moscow),
            getString(R.string.office_Minsk),
            getString(R.string.office_Gomel),
            getString(R.string.office_Spb),
            getString(R.string.office_Kazan)
        )

        officeType = arrayOf(
            TYPE_RU,
            TYPE_BY,
            TYPE_BY,
            TYPE_RU,
            TYPE_RU
        )

        for (i in officeAddress.indices){
            val office = OfficeItem(officeAddress[i], officeType[i])
            officeArrayList.add(office)
        }
    }

    companion object {

        fun newInstance() = OfficesFragment()

        const val TYPE_BY = "BY"
        const val TYPE_RU = "RU"
    }
}