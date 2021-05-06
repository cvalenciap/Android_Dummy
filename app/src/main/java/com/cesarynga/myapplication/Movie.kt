package com.cesarynga.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(
    @SerializedName("objectId") @PrimaryKey val id: String,
    @SerializedName("nombre") val title: String,
    @SerializedName("sinopsis") val synopsis: String,
    @SerializedName("imagenUrl") val imageUrl: String
)