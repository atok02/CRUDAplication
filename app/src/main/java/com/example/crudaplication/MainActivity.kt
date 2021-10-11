package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crudaplication.DataSiswa
import com.example.crudaplication.R

class MainActivity : AppCompatActivity() {
    private lateinit var inputnis : EditText
    private lateinit var inputnama : EditText
    private lateinit var laki : RadioButton
    private lateinit var perempuan : RadioButton
    private lateinit var simpan : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputnis = findViewById(R.id.nis)
        inputnama= findViewById(R.id.nama)
        laki= findViewById(R.id.laki)
        perempuan= findViewById(R.id.perempuan)
        simpan = findViewById(R.id.simpan)
        recyclerView= findViewById(R.id.recyclerView)
        //membuat variabel kosong tipe array Mutablelist untuk simpan data array
        //data array disimpan di data class Siswa data
        val data = mutableListOf<DataSiswa>()
        viewManager= LinearLayoutManager(this)
        recyclerAdapter= SiswaAdapter(data)
        recyclerView.adapter= recyclerAdapter
        recyclerView.layoutManager=viewManager
        //setOnclickListener untuk tombol tambah data
        simpan.setOnClickListener{
            val nis = inputnis.text.toString()
            val nama = inputnama.text.toString()
            var jekel = ""
            if(laki.isChecked){
                jekel= "laki"
            } else {
                jekel ="perempuan"
            }
            val dataSiswa = DataSiswa (nis,nama,jekel)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }

    }


}