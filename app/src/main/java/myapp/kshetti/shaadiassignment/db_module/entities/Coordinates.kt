package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Coordinates (

   @ColumnInfo(name = "coordinates_latitude")
   @SerializedName("latitude") var latitude : String,

   @ColumnInfo(name = "coordinates_longitude")
   @SerializedName("longitude") var longitude : String

)