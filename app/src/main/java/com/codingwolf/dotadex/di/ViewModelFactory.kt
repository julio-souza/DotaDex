package com.codingwolf.dotadex.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val creatorMap: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator: Provider<out ViewModel> = creatorMap[modelClass]
            ?: creatorMap.entries.first { (viewModelClass, _) -> modelClass.isAssignableFrom(viewModelClass) }.value
            ?: throw IllegalArgumentException("Cannot create from model: $modelClass")


        return creator.get() as T
    }
}
