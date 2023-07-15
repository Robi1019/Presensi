package com.example.presensi.MenuUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presensi.R

private lateinit var adapter: RecyclerFisrtAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var firstArrayList: ArrayList<First>

lateinit var TanggalMasuk: Array<String>
lateinit var TanggalPulang: Array<String>
lateinit var JmMasuk: Array<String>
lateinit var JmPulang: Array<String>

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_fragmentfirst)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RecyclerFisrtAdapter(firstArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        firstArrayList = arrayListOf<First>()

        TanggalMasuk = arrayOf(
            "09-06-2023",
            "10-06-2023", "11-06-2023", "12-06-2023",
            "13-06-2023", "14-06-2023", "15-06-2023",
            "16-06-2023"
        )

        TanggalPulang = arrayOf(
            "09-06-2023",
            "10-06-2023", "11-06-2023", "12-06-2023",
            "13-06-2023", "14-06-2023", "15-06-2023",
            "16-06-2023"
        )

        JmMasuk = arrayOf(
            "08 : 01",
            "08 : 02", "08 : 03", "08 : 04",
            "09 : 00", "09 : 07", "09 : 04",
            "09 : 09"
        )

        JmPulang = arrayOf(
            "08 : 01",
            "08 : 02", "08 : 03", "08 : 04",
            "09 : 00", "09 : 07", "09 : 04",
            "09 : 09"
        )

        for (i in TanggalMasuk.indices){
            val first = First(TanggalMasuk[i], TanggalPulang[i], JmMasuk[i], JmPulang[i])
            firstArrayList.add(first)
        }
    }
}