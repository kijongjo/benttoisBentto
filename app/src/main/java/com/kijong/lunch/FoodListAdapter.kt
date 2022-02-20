package com.kijong.lunch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodListAdapter(val items :MutableList<String>) : RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.foodlist_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodListAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
       return items.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(item:String){
            val fl_text = itemView.findViewById<TextView>(R.id.flItem)
            fl_text.text = item
        }
    }
}