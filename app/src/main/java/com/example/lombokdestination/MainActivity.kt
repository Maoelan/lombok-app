package com.example.lombokdestination

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvDestination: RecyclerView
    private val list = ArrayList<Destination>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDestination = findViewById(R.id.rv_destinations)
        rvDestination.setHasFixedSize(true)

        list.addAll(getListDestinations())
        showRecyclerList()
    }

    private fun getListDestinations(): ArrayList<Destination> {
        val dataDestination = resources.getStringArray(R.array.destination_name)
        val dataOverview = resources.getStringArray(R.array.destination_overview)
        val dataPhoto = resources.obtainTypedArray(R.array.destination_photo)
        val listDestination = ArrayList<Destination>()
        for (i in dataDestination.indices){
            val destination = Destination(dataDestination[i], dataOverview[i], dataPhoto.getResourceId(i, -1))
            listDestination.add(destination)
        }
        return listDestination
    }

    private fun showRecyclerList() {
        rvDestination.layoutManager = LinearLayoutManager(this)
        val listDestinationAdapter = ListDestinationAdapter(list)
        rvDestination.adapter = listDestinationAdapter
    }
}