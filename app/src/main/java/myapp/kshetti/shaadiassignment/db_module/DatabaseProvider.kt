package myapp.kshetti.shaadiassignment.db_module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import myapp.kshetti.shaadiassignment.db_module.database.UserDataBase
import myapp.kshetti.trialapp.model.Results.Companion.TABLE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseProvider() {

    @Provides
    @Singleton
    fun getUserDatabase(@ApplicationContext context: Context): UserDataBase{
            return Room.databaseBuilder(
                context.applicationContext,
                UserDataBase::class.java,
                TABLE_NAME
            ).build()
    }

    @Provides
    @Singleton
    fun getUserDao(@ActivityRetainedScoped userDataBase: UserDataBase) = userDataBase.userDao()

}