package myapp.kshetti.shaadiassignment.api_module

import androidx.lifecycle.LiveData
import myapp.kshetti.trialapp.model.UserData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {
    @GET("api/?results=10")
    fun getProfileList(): Call<UserData>
}