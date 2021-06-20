package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

   
data class Location (

   @Embedded
   @SerializedName("street") var street : Street,

   @ColumnInfo(name = "city")
   @SerializedName("city") var city : String,

   @ColumnInfo(name = "state")
   @SerializedName("state") var state : String,

   @ColumnInfo(name = "country")
   @SerializedName("country") var country : String,

   @ColumnInfo(name = "postcode")
   @SerializedName("postcode") var postcode : String,

   @Embedded
   @SerializedName("coordinates") var coordinates : Coordinates,

   @Embedded
   @SerializedName("timezone") var timezone : Timezone

)