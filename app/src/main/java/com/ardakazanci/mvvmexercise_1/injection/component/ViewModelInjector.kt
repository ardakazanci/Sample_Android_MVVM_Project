package com.ardakazanci.mvvmexercise_1.injection.component

import com.ardakazanci.mvvmexercise_1.injection.module.NetworkModule
import com.ardakazanci.mvvmexercise_1.ui.photos.PhotosListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(photosViewModel: PhotosListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}
