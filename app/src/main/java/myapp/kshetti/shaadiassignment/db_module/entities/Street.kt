package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Street (

   @ColumnInfo(name = "street_number")
   @SerializedName("number") var number : Int,

   @ColumnInfo(name = "street_name")
   @SerializedName("name") var name : String

)