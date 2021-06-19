package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Registered (

   @ColumnInfo(name = "registered_date")
   @SerializedName("date") var date : String,

   @ColumnInfo(name = "registered_age")
   @SerializedName("age") var age : Int

)