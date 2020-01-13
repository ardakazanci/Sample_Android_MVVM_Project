package com.ardakazanci.mvvmexercise_1.base

import androidx.lifecycle.ViewModel
import com.ardakazanci.mvvmexercise_1.injection.component.DaggerViewModelInjector
import com.ardakazanci.mvvmexercise_1.injection.component.ViewModelInjector
import com.ardakazanci.mvvmexercise_1.injection.module.NetworkModule
import com.ardakazanci.mvvmexercise_1.ui.photos.PhotosListViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PhotosListViewModel -> injector.inject(this)
        }
    }


}