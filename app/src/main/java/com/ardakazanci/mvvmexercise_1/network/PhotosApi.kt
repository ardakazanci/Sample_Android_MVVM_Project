package com.ardakazanci.mvvmexercise_1.network


import com.ardakazanci.mvvmexercise_1.model.Photos
import io.reactivex.Observable
import retrofit2.http.GET

interface PhotosApi {

    @GET("/photos")
    fun getPhotos(): Observable<List<Photos>>

}