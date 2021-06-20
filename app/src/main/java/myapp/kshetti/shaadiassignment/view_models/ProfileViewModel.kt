package myapp.kshetti.shaadiassignment.view_models

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import myapp.kshetti.shaadiassignment.Utility
import myapp.kshetti.shaadiassignment.repositories.UserRepository
import myapp.kshetti.trialapp.model.Results
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    @ViewModelScoped
    @Inject
    lateinit var userRepository: UserRepository

    @ActivityRetainedScoped
    @Inject
    lateinit var utility: Utility

    var userList = MutableLiveData<List<Results>>()

    fun insertAndFetchUsers() {
        viewModelScope.launch() {
            userList.value = userRepository.insertAndFetchUsers()
        }
    }

    fun fetchStoredUsers() {
        viewModelScope.launch() {
            userList.value = userRepository.fetchStoredUsers()
        }
    }

    fun updateAcceptanceState(niqueID: Long, status: Int) {
        viewModelScope.launch() {
            userRepository.updateAcceptanceState(niqueID, status)
        }
    }

    fun isNetworkConnected() = utility.isNetworkConnected()

    fun saveViewedPosition(uID: Long) = utility.saveViewedPosition(uID)

    fun getViewedPosition() = utility.getViewedPosition()
}