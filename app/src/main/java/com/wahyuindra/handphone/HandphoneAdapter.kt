package com.wahyuindra.handphone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.handphone_item.*

class HandphoneAdapter(private val context: Context, private val items: ArrayList<Handphone>) :
    RecyclerView.Adapter<HandphoneAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.handphone_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: Handphone) {
            txtNama.text = item.nama
            txtOS.text = "OS " + item.os
            txtChipset.text = "Chipset : " + item.chipset
            txtDisplay.text = "Display : " + item.display
            txtCamera.text = "Camera : " + item.camera
            txtMemory.text = "Memory : " + item.memory
            txtBattery.text = "Battery : " + item.battery
            txtHarga.text = "Harga Rp. " + item.harga
        }

    }


}