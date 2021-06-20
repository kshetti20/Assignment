package myapp.kshetti.shaadiassignment.repositories

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.scopes.ActivityRetainedScoped
import myapp.kshetti.shaadiassignment.api_module.RestApi
import myapp.kshetti.shaadiassignment.db_module.dao.UserDao
import myapp.kshetti.trialapp.model.UserData
import java.lang.reflect.Type
import javax.inject.Inject


class UserRepository @Inject constructor(
    @ActivityRetainedScoped val userDao: UserDao,
    @ActivityRetainedScoped val restApi: RestApi
) {
    suspend fun getUsers(): UserData? {
        val apiCall = restApi.getProfileList()
        val users: UserData? = apiCall.execute().body()
        return users
    }
}