package myapp.kshetti.shaadiassignment.api_module

import myapp.kshetti.trialapp.model.UserData
import retrofit2.Call
import retrofit2.http.GET

interface RestApi {
    @GET("api/?results=10")
    fun getProfileList(): Call<UserData>
}