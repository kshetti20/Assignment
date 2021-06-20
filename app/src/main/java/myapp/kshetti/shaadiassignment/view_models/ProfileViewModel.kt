package myapp.kshetti.shaadiassignment.view_models

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import myapp.kshetti.shaadiassignment.repositories.UserRepository
import myapp.kshetti.trialapp.model.UserData
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    @ViewModelScoped
    @Inject
    lateinit var userRepository: UserRepository

    var data = MutableLiveData<UserData>()

    fun getUsers() {
        viewModelScope.launch() {
            data.value = userRepository.getUsers()
        }
    }
}