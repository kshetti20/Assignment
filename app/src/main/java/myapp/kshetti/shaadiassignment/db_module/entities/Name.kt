package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Name (

   @ColumnInfo(name = "title")
   @SerializedName("title") var title : String,

   @ColumnInfo(name = "first")
   @SerializedName("first") var first : String,

   @ColumnInfo(name = "last")
   @SerializedName("last") var last : String

)