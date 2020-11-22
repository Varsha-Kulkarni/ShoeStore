package com.example.varshakulkarni.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created By Varsha Kulkarni on 19/11/20
 */

@Parcelize
data class Shoe(var name: String, var size: Double, var brand: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable