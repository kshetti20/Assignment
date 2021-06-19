package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Name (

   @ColumnInfo(name = "name_title")
   @SerializedName("title") var title : String,

   @ColumnInfo(name = "name_first")
   @SerializedName("first") var first : String,

   @ColumnInfo(name = "name_last")
   @SerializedName("last") var last : String

)