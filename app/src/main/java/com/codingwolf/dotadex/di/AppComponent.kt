package com.codingwolf.dotadex.di

import android.content.Context
import com.codingwolf.dotadex.local.di.LocalDataSourceModule
import com.codingwolf.dotadex.local.di.LocalModule
import com.codingwolf.dotadex.network.di.NetworkModule
import com.codingwolf.dotadex.network.di.RemoteDataSourceModule
import com.codingwolf.dotadex.ui.login.di.LoginComponent
import com.codingwolf.dotadex.ui.main.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelBindingModule::class,
        NetworkModule::class,
        ActivitySubComponentsModule::class,
        LocalModule::class,
        LocalDataSourceModule::class,
        RemoteDataSourceModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun loginComponent(): LoginComponent.Factory
    fun mainComponent(): MainComponent.Factory
}
