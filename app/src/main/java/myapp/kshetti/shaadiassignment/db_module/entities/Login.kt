package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

   
data class Login (

   @ColumnInfo(name = "login_uuid")
   @SerializedName("uuid") var uuid : String,

   @ColumnInfo(name = "login_username")
   @SerializedName("username") var username : String,

   @ColumnInfo(name = "login_password")
   @SerializedName("password") var password : String,

   @ColumnInfo(name = "login_salt")
   @SerializedName("salt") var salt : String,

   @ColumnInfo(name = "login_md5")
   @SerializedName("md5") var md5 : String,

   @ColumnInfo(name = "login_sha1")
   @SerializedName("sha1") var sha1 : String,

   @ColumnInfo(name = "login_sha256")
   @SerializedName("sha256") var sha256 : String

)