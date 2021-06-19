package myapp.kshetti.shaadiassignment.db_module.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import myapp.kshetti.shaadiassignment.db_module.entities.UserEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = PROFILE_ID) var id: Long = 0,
    @ColumnInfo(name = PROFILE_NAME) var name: String
) {
    companion object {
        const val TABLE_NAME = "user"
        const val PROFILE_ID = "id"
        const val PROFILE_NAME = "name"
    }
}

