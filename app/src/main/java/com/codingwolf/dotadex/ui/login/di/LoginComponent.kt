package com.codingwolf.dotadex.ui.login.di

import com.codingwolf.dotadex.ui.login.LoginActivity
import com.codingwolf.dotadex.ui.login.LoginFragment
import dagger.Subcomponent

@AuthenticationScope
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(activity: LoginActivity)

    fun inject(fragment: LoginFragment)
}
