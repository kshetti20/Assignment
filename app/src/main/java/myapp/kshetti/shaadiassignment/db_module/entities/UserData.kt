package myapp.kshetti.trialapp.model

import com.google.gson.annotations.SerializedName

   
data class UserData (

   @SerializedName("results") var results : List<Results>,
   @SerializedName("info") var info : Info

)