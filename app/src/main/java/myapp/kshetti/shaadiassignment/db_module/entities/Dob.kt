package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Dob (

   @ColumnInfo(name = "dob_date")
   @SerializedName("date") var date : String,

   @ColumnInfo(name = "dob_age")
   @SerializedName("age") var age : Int

)