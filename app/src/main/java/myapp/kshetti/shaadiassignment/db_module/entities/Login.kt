package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Login (

   @ColumnInfo(name = "uuid")
   @SerializedName("uuid") var uuid : String,

   @ColumnInfo(name = "username")
   @SerializedName("username") var username : String,

   @ColumnInfo(name = "password")
   @SerializedName("password") var password : String,

   @ColumnInfo(name = "salt")
   @SerializedName("salt") var salt : String,

   @ColumnInfo(name = "md5")
   @SerializedName("md5") var md5 : String,

   @ColumnInfo(name = "sha1")
   @SerializedName("sha1") var sha1 : String,

   @ColumnInfo(name = "sha256")
   @SerializedName("sha256") var sha256 : String

)