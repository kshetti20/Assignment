package myapp.kshetti.shaadiassignment.repositories

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import myapp.kshetti.shaadiassignment.api_module.RestApi
import myapp.kshetti.shaadiassignment.db_module.dao.UserDao
import myapp.kshetti.trialapp.model.Results
import javax.inject.Inject


class UserRepository @Inject constructor(
    @ActivityRetainedScoped val userDao: UserDao,
    @ActivityRetainedScoped val restApi: RestApi
) {
    suspend fun insertAndFetchUsers(): List<Results>? {
        return withContext(Dispatchers.IO) {
            val apiCall = restApi.getProfileList()
            val userData = apiCall.execute().body()

            userDao.insertAll(userData?.results)
            userDao.getStoredProfiles()
        }
    }

    suspend fun fetchStoredUsers(): List<Results>? {
        return withContext(Dispatchers.IO) {
            userDao.getStoredProfiles()
        }
    }

    suspend fun updateAcceptanceState(uniqueID: Long, status: Int) {
        withContext(Dispatchers.IO) {
            userDao.updateAcceptanceState(uniqueID, status)
        }
    }
}