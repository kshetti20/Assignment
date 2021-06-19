package myapp.kshetti.shaadiassignment.db_module.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import myapp.kshetti.shaadiassignment.db_module.dao.UserDao
import myapp.kshetti.shaadiassignment.db_module.entities.UserEntity

@Database(entities = arrayOf(UserEntity::class), version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}