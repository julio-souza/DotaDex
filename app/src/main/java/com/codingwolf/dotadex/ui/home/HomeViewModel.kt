package com.codingwolf.dotadex.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwolf.dotadex.data.model.steam.profile.Profile
import com.codingwolf.dotadex.data.respository.Result
import com.codingwolf.dotadex.domain.usecase.ProfileUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val profileUseCase: ProfileUseCase) : ViewModel() {

    private val _profile = MutableLiveData<Profile>()
    val profile: LiveData<Profile>
        get() = _profile

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            profileUseCase.getUserProfile().also { result ->
                when (result) {
                    is Result.Success -> _profile.value = result.value
                    is Result.Error -> dealWithError(result)
                }
            }
        }
    }

    private fun dealWithError(result: Result.Error) {
        TODO("Deal with error ${result.error}")
    }
}
