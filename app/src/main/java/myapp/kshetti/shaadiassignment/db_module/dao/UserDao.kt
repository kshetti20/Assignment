package myapp.kshetti.shaadiassignment.db_module.dao

import androidx.room.Dao
import androidx.room.Query
import myapp.kshetti.shaadiassignment.db_module.entities.UserEntity
import myapp.kshetti.shaadiassignment.db_module.entities.UserEntity.Companion.PROFILE_ID
import myapp.kshetti.shaadiassignment.db_module.entities.UserEntity.Companion.TABLE_NAME

@Dao
interface UserDao {

    @Query("SELECT * FROM $TABLE_NAME ORDER BY $PROFILE_ID DESC")
    suspend fun getAllProfiles(): List<UserEntity>? //TODO Get list of ModelClass
}