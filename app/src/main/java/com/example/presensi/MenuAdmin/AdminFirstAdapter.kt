package com.example.presensi.MenuAdmin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.presensi.MenuUser.First
import com.example.presensi.MenuUser.RecyclerFisrtAdapter
import com.example.presensi.R

class AdminFirstAdapter (private val firstList: ArrayList<FirstAdmin>) : RecyclerView.Adapter<AdminFirstAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nm1: TextView = itemView.findViewById(R.id.nama1)
        val nm2: TextView = itemView.findViewById(R.id.nama2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_first_admin,
            parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return firstList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = firstList[position]
        holder.nm1.text = currentItem.nama
        holder.nm2.text = currentItem.namatitle
    }
}