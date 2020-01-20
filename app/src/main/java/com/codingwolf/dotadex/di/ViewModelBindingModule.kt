package com.codingwolf.dotadex.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwolf.dotadex.di.key.ViewModelKey
import com.codingwolf.dotadex.ui.search.SearchViewModel
import com.codingwolf.dotadex.ui.home.HomeViewModel
import com.codingwolf.dotadex.ui.notifications.NotificationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBindingModule {

    @Binds
    @IntoMap
    @ViewModelKey(value = SearchViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(value = HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(value = NotificationsViewModel::class)
    abstract fun bindNotificationsViewModel(viewModel: NotificationsViewModel): ViewModel


    /**
     * Check the need for suppressing wild cards on the return type
     * @JvmSuppressWildcards ViewModelProvider.Factory
     */
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
