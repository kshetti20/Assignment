package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Id (

   @ColumnInfo(name = "id_name")
   @SerializedName("name") var name : String,

   @ColumnInfo(name = "id_value")
   @SerializedName("value") var value : String

)