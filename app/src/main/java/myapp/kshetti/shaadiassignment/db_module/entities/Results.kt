package myapp.kshetti.trialapp.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import myapp.kshetti.trialapp.model.Results.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Results(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = PROFILE_ID) var uID: Long = 0,

    @ColumnInfo(name = "gender")
    @SerializedName("gender") var gender: String,

    @Embedded
    @SerializedName("name") var name: Name,

    @Embedded
    @SerializedName("location") var location: Location,

    @ColumnInfo(name = "email")
    @SerializedName("email") var email: String,

    @Embedded
    @SerializedName("login") var login: Login,

    @Embedded
    @SerializedName("dob") var dob: Dob,

    @Embedded
    @SerializedName("registered") var registered: Registered,

    @ColumnInfo(name = "phone")
    @SerializedName("phone") var phone: String,

    @ColumnInfo(name = "cell")
    @SerializedName("cell") var cell: String,

    @Embedded
    @SerializedName("id") var id: Id,

    @Embedded
    @SerializedName("picture") var picture: Picture,

    @ColumnInfo(name = "nat")
    @SerializedName("nat") var nat: String
){

    companion object {
        const val TABLE_NAME = "user"
        const val PROFILE_ID = "id"
        const val PROFILE_NAME = "name"
    }
}