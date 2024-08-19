package com.example.lombokdestination

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Destination(
    val destination: String? = null,
    val overview: String? = null,
    val photo: Int,
    val location: String? = null,
    val coordinate: String? = null,
    val activities: List<String>? = null,
    val facilities: List<String>? = null,
    val ticketPrice: String? = null,
    val bestVisitTime: String? = null,
    val note: String? = null
) : Parcelable
