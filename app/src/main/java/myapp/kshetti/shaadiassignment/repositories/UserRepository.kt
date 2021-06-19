package myapp.kshetti.shaadiassignment.repositories

import dagger.hilt.android.scopes.ActivityRetainedScoped
import myapp.kshetti.shaadiassignment.api_module.RestApi
import myapp.kshetti.shaadiassignment.db_module.dao.UserDao
import javax.inject.Inject


class UserRepository @Inject constructor(
    @ActivityRetainedScoped val userDao: UserDao,
    @ActivityRetainedScoped val restApi: RestApi
)