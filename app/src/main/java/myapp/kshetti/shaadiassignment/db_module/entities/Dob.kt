package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Dob (

   @ColumnInfo(name = "date")
   @SerializedName("date") var date : String,

   @ColumnInfo(name = "age")
   @SerializedName("age") var age : Int

)