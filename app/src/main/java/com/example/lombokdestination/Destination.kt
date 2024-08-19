package com.example.lombokdestination

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Destination(
    val destination: String,
    val overview: String,
    val photo: Int,
) : Parcelable
