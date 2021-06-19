package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Picture (

   @ColumnInfo(name = "picture_large")
   @SerializedName("large") var large : String,

   @ColumnInfo(name = "picture_medium")
   @SerializedName("medium") var medium : String,

   @ColumnInfo(name = "picture_thumbnail")
   @SerializedName("thumbnail") var thumbnail : String

)