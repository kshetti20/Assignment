package myapp.kshetti.shaadiassignment.ui_controllers.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import myapp.kshetti.shaadiassignment.databinding.FragmentHorizontalListBinding
import myapp.kshetti.shaadiassignment.databinding.FragmentVerticalListBinding

class VerticalListFragment : Fragment() {

    private lateinit var binding: FragmentVerticalListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerticalListBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }
}