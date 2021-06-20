package myapp.kshetti.shaadiassignment.repositories

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import myapp.kshetti.shaadiassignment.api_module.RestApi
import myapp.kshetti.shaadiassignment.db_module.dao.UserDao
import myapp.kshetti.trialapp.model.UserData
import javax.inject.Inject


class UserRepository @Inject constructor(
    @ActivityRetainedScoped val userDao: UserDao,
    @ActivityRetainedScoped val restApi: RestApi
) {
    suspend fun getUsers(): UserData? {
        return withContext(Dispatchers.IO) {
            val apiCall = restApi.getProfileList()
            apiCall.execute().body()
        }
    }
}