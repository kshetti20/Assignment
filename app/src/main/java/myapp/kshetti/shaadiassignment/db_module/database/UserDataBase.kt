package myapp.kshetti.shaadiassignment.db_module.database

import androidx.room.Database
import androidx.room.RoomDatabase
import myapp.kshetti.shaadiassignment.db_module.dao.UserDao
import myapp.kshetti.trialapp.model.Results

@Database(entities = arrayOf(Results::class), version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}