package myapp.kshetti.shaadiassignment.ui_controllers.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import myapp.kshetti.shaadiassignment.R
import myapp.kshetti.shaadiassignment.adapters.UserCardAdapter
import myapp.kshetti.shaadiassignment.databinding.FragmentVerticalListBinding
import myapp.kshetti.shaadiassignment.view_models.ProfileViewModel

class VerticalListFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by activityViewModels()

    private lateinit var binding: FragmentVerticalListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVerticalListBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            userProfileRV.layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
            )

            profileViewModel.userList.observe(viewLifecycleOwner, {
                if (it.isNullOrEmpty()) {
                    binding.userProfileRV.visibility = View.GONE
                    binding.backgroundIV.setImageDrawable(
                        ContextCompat.getDrawable(
                            activity as Context,
                            R.drawable.no_internet
                        )
                    )
                } else {
                    binding.backgroundIV.visibility = View.GONE
                    userProfileRV.adapter = UserCardAdapter(it) {
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
}
