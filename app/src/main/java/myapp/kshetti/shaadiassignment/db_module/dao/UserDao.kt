package myapp.kshetti.shaadiassignment.db_module.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import myapp.kshetti.trialapp.model.Results
import myapp.kshetti.trialapp.model.Results.Companion.STATUS
import myapp.kshetti.trialapp.model.Results.Companion.TABLE_NAME
import myapp.kshetti.trialapp.model.Results.Companion.UNIQUE_ID


@Dao
interface UserDao {

    @Query("SELECT * FROM $TABLE_NAME ORDER BY $UNIQUE_ID ASC")
    suspend fun getStoredProfiles(): List<Results>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewUser(results: Results?): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<Results>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNewUsers(resultsList: List<Results>?)

    @Query("UPDATE $TABLE_NAME SET $STATUS = :status WHERE $UNIQUE_ID = :uniqueID")
    fun updateAcceptanceState(uniqueID: Long, status: Int)
}