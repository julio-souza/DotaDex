package com.codingwolf.dotadex.di

import android.content.Context
import com.codingwolf.dotadex.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component


@Component(modules = [ViewModelBindingModule::class, NetworkModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

}
