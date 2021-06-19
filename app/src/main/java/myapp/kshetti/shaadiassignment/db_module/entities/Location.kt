package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

   
data class Location (

   @Embedded
   @SerializedName("location_street") var street : Street,

   @ColumnInfo(name = "location_city")
   @SerializedName("city") var city : String,

   @ColumnInfo(name = "location_state")
   @SerializedName("state") var state : String,

   @ColumnInfo(name = "location_country")
   @SerializedName("country") var country : String,

   @ColumnInfo(name = "location_postcode")
   @SerializedName("postcode") var postcode : Int,

   @Embedded
   @SerializedName("coordinates") var coordinates : Coordinates,

   @Embedded
   @SerializedName("timezone") var timezone : Timezone

)