package myapp.kshetti.shaadiassignment.ui_controllers

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped
import myapp.kshetti.shaadiassignment.api_module.RestApi
import myapp.kshetti.shaadiassignment.api_module.RestClient
import myapp.kshetti.shaadiassignment.view_models.ProfileViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}