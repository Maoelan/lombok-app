package com.example.lombokdestination

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        val dataLocation = resources.getStringArray(R.array.destination_location)
        val dataCoordinate = resources.getStringArray(R.array.destination_coordinate)
        val dataActivity = resources.getStringArray(R.array.destination_activity)
        val dataFacility = resources.getStringArray(R.array.destination_facility)
        val dataTicket = resources.getStringArray(R.array.destination_ticket)
        val dataTime = resources.getStringArray(R.array.destination_time)
        val dataNote = resources.getStringArray(R.array.destination_note)
        val dataPhoto = resources.obtainTypedArray(R.array.destination_photo)
        val listDestination = ArrayList<Destination>()
        for (i in dataDestination.indices) {
            val destination = Destination(
                dataDestination[i],
                dataOverview[i],
                dataPhoto.getResourceId(i, -1),
                dataLocation[i],
                dataCoordinate[i],
                dataActivity[i].split(", "),
                dataFacility[i].split(", "),
                dataTicket[i],
                dataTime[i],
                dataNote[i]
            )
            listDestination.add(destination)
        }
        return listDestination
    }

    private fun showRecyclerList() {
        rvDestination.layoutManager = LinearLayoutManager(this)
        val listDestinationAdapter = ListDestinationAdapter(list)
        rvDestination.adapter = listDestinationAdapter
        
        listDestinationAdapter.setOnItemClickCallback(object : ListDestinationAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Destination) {
                showSelectedDestination(data)
            }
        })
    }

    private fun showSelectedDestination(destination: Destination) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_DESTINATION, destination)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about) {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}