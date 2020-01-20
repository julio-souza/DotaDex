package com.codingwolf.dotadex.di.key

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)
