package myapp.kshetti.shaadiassignment.ui_controllers

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import myapp.kshetti.shaadiassignment.view_models.ProfileViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}