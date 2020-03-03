package com.codingwolf.dotadex.ui.login.di

import androidx.lifecycle.ViewModel
import com.codingwolf.dotadex.di.key.ViewModelKey
import com.codingwolf.dotadex.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

    @AuthenticationScope
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindsLoginViewModel(viewModel: LoginViewModel): ViewModel
}
