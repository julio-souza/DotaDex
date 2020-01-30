package com.codingwolf.dotadex.di

import com.codingwolf.dotadex.ui.login.di.LoginComponent
import com.codingwolf.dotadex.ui.main.di.MainComponent
import dagger.Module

@Module(subcomponents = [LoginComponent::class, MainComponent::class])
object ActivitySubComponentsModule
