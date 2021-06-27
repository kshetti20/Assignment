package myapp.kshetti.shaadiassignment.ui_controllers.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import myapp.kshetti.shaadiassignment.databinding.FragmentHorizontalListBinding
import javax.inject.Inject

@AndroidEntryPoint
class HorizontalListFragment: Fragment() {

    private lateinit var binding: FragmentHorizontalListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHorizontalListBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }
}