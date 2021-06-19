package myapp.kshetti.shaadiassignment.db_module.dao

import androidx.room.Dao
import androidx.room.Query
import myapp.kshetti.trialapp.model.Results
import myapp.kshetti.trialapp.model.Results.Companion.PROFILE_ID
import myapp.kshetti.trialapp.model.Results.Companion.TABLE_NAME


@Dao
interface UserDao {

    @Query("SELECT * FROM $TABLE_NAME ORDER BY $PROFILE_ID DESC")
    suspend fun getAllProfiles(): List<Results>?
}