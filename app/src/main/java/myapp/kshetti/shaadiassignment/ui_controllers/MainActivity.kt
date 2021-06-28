package myapp.kshetti.shaadiassignment.ui_controllers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import myapp.kshetti.shaadiassignment.R
import myapp.kshetti.shaadiassignment.databinding.ActivityMainBinding
import myapp.kshetti.shaadiassignment.ui_controllers.fragments.HorizontalListFragment
import myapp.kshetti.shaadiassignment.ui_controllers.fragments.VerticalListFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val titleList = arrayListOf("Horizontal List", "Vertical list")

        binding.apply {

            selectionTab.setCallback { current, previous ->
                loadFragment(current, previous)
            }
            selectionTab.setTitle(titleList)
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
            addToBackStack("null")
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

    override fun onBackPressed() {
        super.onBackPressed()
            finish()
    }
}