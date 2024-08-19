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
    val activity: String? = null,
    val facility: String? = null,
    val ticket: String? = null,
    val time: String? = null,
    val note: String? = null
) : Parcelable
