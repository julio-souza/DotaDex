package com.codingwolf.dotadex.ui.main.di

import androidx.lifecycle.ViewModel
import com.codingwolf.dotadex.di.key.ViewModelKey
import com.codingwolf.dotadex.ui.main.home.HomeViewModel
import com.codingwolf.dotadex.ui.main.notifications.NotificationsViewModel
import com.codingwolf.dotadex.ui.main.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(value = SearchViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(value = HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(value = NotificationsViewModel::class)
    abstract fun bindNotificationsViewModel(viewModel: NotificationsViewModel): ViewModel
}
