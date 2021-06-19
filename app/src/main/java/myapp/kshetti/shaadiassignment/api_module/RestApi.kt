package myapp.kshetti.shaadiassignment.api_module

import retrofit2.Response
import retrofit2.http.GET

interface RestApi {

    @GET("api/?results=10")
    suspend fun getProfileList(): Response<String> //TODO return Response of ModelClass

}