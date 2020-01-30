package com.codingwolf.dotadex.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwolf.dotadex.data.model.Match
import com.codingwolf.dotadex.data.model.profile.Player
import com.codingwolf.dotadex.data.respository.util.Result
import com.codingwolf.dotadex.domain.usecase.MatchUseCase
import com.codingwolf.dotadex.domain.usecase.ProfileUseCase
import com.codingwolf.dotadex.domain.util.DateUtil
import com.codingwolf.dotadex.ui.main.di.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@MainScope
class HomeViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCase,
    private val matchUseCase: MatchUseCase,
    private val dateUtil: DateUtil
) : ViewModel() {

    private val _player = MutableLiveData<Player>()
    val player: LiveData<Player> get() = _player

    private val _matches = MutableLiveData<List<Match>>()
    val matches: LiveData<List<Match>> get() = _matches

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            profileUseCase.getUserProfile(ACCOUNT_ID, OPEN_DOTA_KEY).also { result ->
                when (result) {
                    is Result.Success -> _player.value = result.value
                    is Result.Error -> dealWithError(result)
                }
            }
        }

        viewModelScope.launch {
            matchUseCase.getRecentMatches(ACCOUNT_ID, OPEN_DOTA_KEY).also {result ->
                when(result) {
                    is Result.Success -> _matches.value = result.value
                    is Result.Error -> dealWithError(result)
                }
            }
        }
    }

    private fun dealWithError(err: Result.Error) {
        _error.value = err.error
    }

    companion object {
        const val ACCOUNT_ID = 91481997L
        const val OPEN_DOTA_KEY = "f6d43a1b-7a06-4543-909e-efaf3b8b223d"
    }
}
