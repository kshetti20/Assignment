package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Timezone (

   @ColumnInfo(name = "timezone_offset")
   @SerializedName("offset") var offset : String,

   @ColumnInfo(name = "timezone_description")
   @SerializedName("description") var description : String

)