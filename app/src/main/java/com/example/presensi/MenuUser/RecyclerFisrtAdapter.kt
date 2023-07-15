package com.example.presensi.MenuUser

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.presensi.R

class RecyclerFisrtAdapter(private val firstList: ArrayList<First>) : RecyclerView.Adapter<RecyclerFisrtAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tanggalMsk: TextView = itemView.findViewById(R.id.tglMasuk)
        val tanggalPlg: TextView = itemView.findViewById(R.id.tglPulang)
        val JamMasuk: TextView = itemView.findViewById(R.id.jMasuk)
        val JamPulang: TextView = itemView.findViewById(R.id.jPulang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_fragment_first,
        parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return firstList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = firstList[position]
        holder.tanggalMsk.text = currentItem.tanggalMasuk
        holder.tanggalPlg.text = currentItem.tanggalMasuk
        holder.JamMasuk.text = currentItem.jamMasuk
        holder.JamPulang.text = currentItem.jamPulang
    }
}