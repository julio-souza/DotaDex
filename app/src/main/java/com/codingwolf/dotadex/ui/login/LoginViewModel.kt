package com.codingwolf.dotadex.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwolf.dotadex.data.respository.util.Result
import com.codingwolf.dotadex.domain.usecase.ProfileUseCase
import com.codingwolf.dotadex.ui.util.LiveEvent
import com.codingwolf.dotadex.util.SteamUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val profileUseCase: ProfileUseCase) : ViewModel() {

    private val _onUserLocated = LiveEvent<Unit>()
    val onUserLocated: LiveData<Unit> get() = _onUserLocated

    private val _onFailToLocateUser = LiveEvent<String>()
    val onFailToLocateUser: LiveData<String> get() = _onFailToLocateUser

    init {
        viewModelScope.launch(Dispatchers.IO) {
            when (profileUseCase.getUserProfile()) {
                is Result.Success -> _onUserLocated.asyncCall()
            }
        }
    }

    fun initializeUser(accountId: Long) {
        val steamId = SteamUtil.getSteam32Id(accountId)
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = profileUseCase.initializeUser(steamId)) {
                is Result.Success -> _onUserLocated.asyncCall()
                is Result.Error -> _onFailToLocateUser.postValue(result.error)
            }
        }
    }
}
