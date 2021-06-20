package myapp.kshetti.shaadiassignment.ui_controllers

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import myapp.kshetti.shaadiassignment.R
import myapp.kshetti.shaadiassignment.adapters.UserProfileAdapter
import myapp.kshetti.shaadiassignment.databinding.ActivityMainBinding
import myapp.kshetti.shaadiassignment.view_models.ProfileViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {

            userProfileRV.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            
            profileViewModel.userList.observe(this@MainActivity, Observer {
                userProfileRV.adapter = UserProfileAdapter(it) {
                    profileViewModel.updateAcceptanceState(it.uID, it.status)
                }
            })


            if (profileViewModel.isNetworkConnected()) profileViewModel.insertAndFetchUsers()
            else profileViewModel.fetchStoredUsers()
        }
    }
}