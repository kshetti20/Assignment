package myapp.kshetti.shaadiassignment.view_models

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import myapp.kshetti.shaadiassignment.api_module.RestApi
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(savedStateHandle: SavedStateHandle): ViewModel() {

    @ActivityRetainedScoped
    @Inject
    lateinit var restApi: RestApi


}