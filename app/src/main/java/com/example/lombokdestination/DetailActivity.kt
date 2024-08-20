package com.example.lombokdestination
import android.content.Intent
import com.example.lombokdestination.Destination

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView: ImageView = findViewById(R.id.image_destination_detail)
        val nameTextView: TextView = findViewById(R.id.tv_destination_name_detail)
        val overviewTextView: TextView = findViewById(R.id.tv_destination_overview_detail)
        val locationTextView: TextView = findViewById(R.id.tv_location_detail)
        val coordinateTextView: TextView = findViewById(R.id.tv_coordinate_detail)
        val activityTextView: TextView = findViewById(R.id.tv_activity_detail)
        val facilityTextView: TextView = findViewById(R.id.tv_facility_detail)
        val ticketTextView: TextView = findViewById(R.id.tv_ticket_detail)
        val timeTextView: TextView = findViewById(R.id.tv_time_detail)
        val noteTextView: TextView = findViewById(R.id.tv_note_detail)

        val destination = intent.getParcelableExtra<Destination>(EXTRA_DESTINATION)

        destination?.let {
            imageView.setImageResource(it.photo)
            nameTextView.text = it.destination
            overviewTextView.text = it.overview
            locationTextView.text = it.location
            coordinateTextView.text = it.coordinate
            activityTextView.text = it.activity
            facilityTextView.text = it.facility
            ticketTextView.text = it.ticket
            timeTextView.text = it.time
            noteTextView.text = it.note
        }

        val btnShare:Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener{
            val shareText = """
                Destination: ${destination?.destination}
                Overview: ${destination?.overview}
                Location: ${destination?.location}
                Coordinate: ${destination?.coordinate}
                Activity: ${destination?.activity}
                Facility: ${destination?.facility}
                Ticket Info: ${destination?.ticket}
                Time: ${destination?.time}
                Note: ${destination?.note}
            """.trimIndent()

            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }

            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }

    companion object {
        const val EXTRA_DESTINATION = "extra_destination"
    }
}