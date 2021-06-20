package myapp.kshetti.shaadiassignment.view_models

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import myapp.kshetti.shaadiassignment.repositories.UserRepository
import myapp.kshetti.trialapp.model.Results
import myapp.kshetti.trialapp.model.UserData
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    @ViewModelScoped
    @Inject
    lateinit var userRepository: UserRepository

    var userData = MutableLiveData<UserData>()
    var userList = MutableLiveData<List<Results>>()

    fun fetchNewUsers() {
        viewModelScope.launch() {
            userData.value = userRepository.fetchNewUsers()
        }
    }

    fun insertNewUsers() {
        viewModelScope.launch() {
            userData.value = userRepository.insertNewUsers()
        }
    }

    fun fetchStoredUsers(){
        viewModelScope.launch() {
            userList.value = userRepository.fetchStoredUsers()
        }
    }


}