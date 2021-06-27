package myapp.kshetti.shaadiassignment.ui_controllers

import android.os.Bundle
import android.view.View.GONE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import dagger.hilt.android.AndroidEntryPoint
import myapp.kshetti.shaadiassignment.R
import myapp.kshetti.shaadiassignment.adapters.UserProfileAdapter
import myapp.kshetti.shaadiassignment.databinding.ActivityMainBinding
import myapp.kshetti.shaadiassignment.ui_controllers.fragments.HorizontalListFragment
import myapp.kshetti.shaadiassignment.ui_controllers.fragments.VerticalListFragment
import myapp.kshetti.shaadiassignment.view_models.ProfileViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val titleList = arrayListOf("Horizontal List", "Vertical list")

        binding.apply {

            selectionTab.setCallback() { current, previous ->
                loadFragment(current, previous)
            }
            selectionTab.setTitle(titleList)





            LinearSnapHelper().attachToRecyclerView(userProfileRV)
            userProfileRV.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )

            profileViewModel.userList.observe(this@MainActivity, Observer {
                if (it.isNullOrEmpty()) {
                    binding.userProfileRV.visibility = GONE
                    binding.backgroundIV.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@MainActivity,
                            R.drawable.no_internet
                        )
                    )
                } else {
                    binding.backgroundIV.visibility = GONE
                    userProfileRV.adapter = UserProfileAdapter(it) {
                        profileViewModel.updateAcceptanceState(it.uID, it.status)

                        //Latest acceptance state modified position is considered as the last viewed profile
                        //If this position is the last, UI would display the 1st element
                        profileViewModel.saveViewedPosition(it.uID)
                    }
                    userProfileRV.scrollToPosition(profileViewModel.getViewedPosition().toInt())
                }
            })

            if (profileViewModel.isNetworkConnected()) profileViewModel.insertAndFetchUsers()
            else profileViewModel.fetchStoredUsers()
        }
    }

    private fun loadFragment(current: Int, previous: Int) {
        val fragment = getFragment(current)

        val fragmentTxn = supportFragmentManager.beginTransaction()

        with(fragmentTxn) {
            if (current > previous) {
                setCustomAnimations(
                    R.anim.forward_in,
                    R.anim.backward_out
                )
            } else if (current < previous) {
                setCustomAnimations(
                    R.anim.backward_in,
                    R.anim.forward_out
                )
            }

            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun getFragment(current: Int): Fragment {
        return when (current) {
            0 -> HorizontalListFragment()
            1 -> VerticalListFragment()
            else -> HorizontalListFragment()
        }
    }
}