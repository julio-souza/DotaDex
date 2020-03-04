package com.codingwolf.dotadex.ui.main.di

import com.codingwolf.dotadex.ui.main.MainActivity
import com.codingwolf.dotadex.ui.main.home.HomeFragment
import dagger.Subcomponent

@MainScope
@Subcomponent(
    modules = [
        MainModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)
}
