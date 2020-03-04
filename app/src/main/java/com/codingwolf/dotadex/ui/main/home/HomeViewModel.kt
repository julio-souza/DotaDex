package com.codingwolf.dotadex.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwolf.dotadex.data.model.Match
import com.codingwolf.dotadex.data.model.Profile
import com.codingwolf.dotadex.data.respository.util.Result
import com.codingwolf.dotadex.domain.usecase.MatchUseCase
import com.codingwolf.dotadex.domain.usecase.ProfileUseCase
import com.codingwolf.dotadex.domain.util.DateUtil
import com.codingwolf.dotadex.ui.main.di.MainScope
import com.codingwolf.dotadex.ui.util.LiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@MainScope
class HomeViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCase,
    private val matchUseCase: MatchUseCase
) : ViewModel() {

    private val _player = MutableLiveData<Profile>()
    val player: LiveData<Profile> get() = _player

    private val _matches = MutableLiveData<List<Match>>()
    val matches: LiveData<List<Match>> get() = _matches

    private val _error = LiveEvent<String>()
    val error: LiveData<String> get() = _error

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            profileUseCase.getUserProfile().also { profile ->
                when (profile) {
                    is Result.Success -> {
                        _player.postValue(profile.value)

                        matchUseCase.getRecentMatches(profile.value.accountId).also { matches ->
                            when (matches) {
                                is Result.Success -> _matches.postValue(matches.value)
                                is Result.Error -> dealWithError(matches)
                            }
                        }
                    }
                    is Result.Error -> dealWithError(profile)
                }
            }
        }
    }

    private fun dealWithError(err: Result.Error) {
        _error.value = err.error
    }
}
