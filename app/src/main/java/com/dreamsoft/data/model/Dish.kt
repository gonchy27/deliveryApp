package com.dreamsoft.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dish(val image:String="",
                val name:String="",
                val description:String=""
):Parcelable
//crear el index.html o php y enlazar los .php como en web, para probar, caso contrario seguir investigando
//c-23-02-21
