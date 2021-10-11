package com.example.crudrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crudaplication.DataSiswa
import com.example.crudaplication.R

class SiswaAdapter(private val dataSet: MutableList<DataSiswa>):
    RecyclerView.Adapter<SiswaAdapter.SiswaHolder>() {
    class SiswaHolder(view: View):RecyclerView.ViewHolder(view){
        val Nis = view.findViewById<TextView>(R.id.Nis)
        val Nama = view.findViewById<TextView>(R.id.Nama)
        val KELAMIN = view.findViewById<TextView>(R.id.KELAMIN)
        val EDIT = view.findViewById<TextView>(R.id.EDIT)
        val HAPUS = view.findViewById<TextView>(R.id.HAPUS)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiswaHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.layar3,parent,false
        )
        return SiswaHolder(view)
    }

    override fun onBindViewHolder(holder: SiswaHolder, position: Int) {
        holder.Nis.text = dataSet[position].nis
        holder.Nama.text = dataSet[position].nama
        holder.KELAMIN.text = dataSet[position].jekel


    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}