package myapp.kshetti.shaadiassignment.view_models

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import myapp.kshetti.shaadiassignment.repositories.UserRepository
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(savedStateHandle: SavedStateHandle): ViewModel() {

    @ViewModelScoped
    @Inject
    lateinit var userRepository: UserRepository
}