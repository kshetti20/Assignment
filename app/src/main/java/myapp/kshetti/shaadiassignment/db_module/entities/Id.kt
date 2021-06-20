package myapp.kshetti.trialapp.model

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Id (

   @ColumnInfo(name = "name")
   @SerializedName("name") var name : String,

   @ColumnInfo(name = "value")
   @SerializedName("value") var value : String?

)