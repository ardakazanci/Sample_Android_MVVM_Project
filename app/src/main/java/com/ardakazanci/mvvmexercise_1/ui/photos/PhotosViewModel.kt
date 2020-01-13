package com.ardakazanci.mvvmexercise_1.ui.photos

import androidx.lifecycle.MutableLiveData
import com.ardakazanci.mvvmexercise_1.base.BaseViewModel
import com.ardakazanci.mvvmexercise_1.model.Photos

class PhotosViewModel : BaseViewModel() {

    private val photosTitle: MutableLiveData<String> = MutableLiveData()
    private val photosUrl: MutableLiveData<String> = MutableLiveData()

    fun bind(photos: Photos) {
        photosTitle.value = photos.title
        photosUrl.value = photos.url
    }


    fun getPhotosTitle(): MutableLiveData<String> {

        return photosTitle

    }


    fun getPhotosUrl(): MutableLiveData<String> {
        return photosUrl
    }
}