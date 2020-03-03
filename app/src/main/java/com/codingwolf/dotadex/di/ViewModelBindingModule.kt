package com.codingwolf.dotadex.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelBindingModule {
    /**
     * Check the need for suppressing wild cards on the return type
     * @JvmSuppressWildcards ViewModelProvider.Factory
     */
    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
