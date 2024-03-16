package com.example.cryptocurrencyapp.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrencyapp.R
import com.example.cryptocurrencyapp.domain.model.Coin

class AdopterClass(private var dataList: List<Coin>): RecyclerView.Adapter<AdopterClass.ViewHolderClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvCoinName.text = currentItem.name
        holder.rvCoinSymbol.text = currentItem.symbol

       // Log.d("debug",currentItem.name?:"empty name")
       // Log.d("debug","insid")
    }

    fun updateData(newData: List<Coin>) {
        dataList = newData
        //  Log.d("debug","inside updateData")
        notifyDataSetChanged()
    }

    class ViewHolderClass(private val itemView: View): RecyclerView.ViewHolder(itemView) {

        val rvCoinName:TextView  = itemView.findViewById(R.id.coin_name)
        val rvCoinSymbol: TextView = itemView.findViewById(R.id.coin_symbol)
    }

}