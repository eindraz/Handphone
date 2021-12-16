package com.wahyuindra.handphone

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Handphone(

    @PrimaryKey(autoGenerate = true)
    val handphoneId: Int? = null,
    val nama : String,
    val os : String,
    val chipset : String,
    val display : String,
    val camera: String,
    val memory: String,
    val battery: String,
    val harga: String
)
