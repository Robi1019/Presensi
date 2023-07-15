package com.example.presensi.MenuAdmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presensi.MenuUser.First
import com.example.presensi.MenuUser.JmMasuk
import com.example.presensi.MenuUser.JmPulang
import com.example.presensi.MenuUser.RecyclerFisrtAdapter
import com.example.presensi.MenuUser.TanggalMasuk
import com.example.presensi.MenuUser.TanggalPulang
import com.example.presensi.R

private lateinit var adapter: AdminFirstAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var firstArrayList: ArrayList<FirstAdmin>

lateinit var namajudul: Array<String>
lateinit var namatitle: Array<String>
/**
 * A simple [Fragment] subclass.
 * Use the [FirstAdminFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstAdminFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_admin, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_fragmentfirst)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdminFirstAdapter(firstArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        firstArrayList = arrayListOf<FirstAdmin>()

        namajudul = arrayOf(
            "John",
            "Robi", "Anisa", "Tita",
            "Nurul", "Miftah", "Hexa",
            "Putra"
        )

        namatitle = arrayOf(
            "John",
            "Robi", "Anisa", "Tita",
            "Nurul", "Miftah", "Hexa",
            "Putra"
        )

        for (i in namajudul.indices){
            val first = FirstAdmin(namajudul[i], namatitle[i])
            firstArrayList.add(first)
        }
    }
}