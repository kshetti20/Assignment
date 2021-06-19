package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Picture (

   @ColumnInfo(name = "large")
   @SerializedName("large") var large : String,

   @ColumnInfo(name = "medium")
   @SerializedName("medium") var medium : String,

   @ColumnInfo(name = "thumbnail")
   @SerializedName("thumbnail") var thumbnail : String

)