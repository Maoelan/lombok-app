package com.example.lombokdestination

import android.provider.ContactsContract.RawContacts.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListDestinationAdapter(private val listDestination: ArrayList<Destination>) : RecyclerView.Adapter<ListDestinationAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Destination)
    }

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallBack
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.destination_item_photo)
        val tvDestination: TextView = itemView.findViewById(R.id.tv_destination_name)
        val tvOverview: TextView = itemView.findViewById(R.id.tv_destination_overview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_destination, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listDestination.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (destination, overview, photo) = listDestination[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvDestination.text = destination
        holder.tvOverview.text = overview
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listDestination[holder.adapterPosition])}
    }
}