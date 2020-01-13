package com.ardakazanci.mvvmexercise_1.ui.photos

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.ardakazanci.mvvmexercise_1.R
import com.ardakazanci.mvvmexercise_1.base.BaseViewModel
import com.ardakazanci.mvvmexercise_1.model.Photos
import com.ardakazanci.mvvmexercise_1.network.PhotosApi
import com.ardakazanci.mvvmexercise_1.ui.photos.adapter.PhotosListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotosListViewModel : BaseViewModel() {
    val postListAdapter: PhotosListAdapter = PhotosListAdapter()


    @Inject
    lateinit var photosApi: PhotosApi


    // View.INVISIBLE or View.VISIBLE
    val vmProgressStatus: MutableLiveData<Int> = MutableLiveData()

    val errorMessage: MutableLiveData<Int> = MutableLiveData()

    // Retry Clicked
    val errorClickListener = View.OnClickListener { loadPhotos() }


    private lateinit var subscription: Disposable

    init {
        loadPhotos()
    }

    private fun loadPhotos() {

        subscription = photosApi.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() } // Subscribe Start
            .doOnTerminate { onRetrievePostListFinish() } // Subscribe Finish
            .subscribe(
                {result-> onRetrievePostListSuccess(result) }, // onNext
                { onRetrievePostListError() } // onError
            )


    }


    private fun onRetrievePostListError() {
        errorMessage.value = R.string.photos_error
    }

    private fun onRetrievePostListSuccess(photosList : List<Photos>) {
        postListAdapter.updatePostList(photosList)
    }

    private fun onRetrievePostListFinish() {
        vmProgressStatus.value = View.GONE
    }

    private fun onRetrievePostListStart() {
        vmProgressStatus.value = View.VISIBLE
        errorMessage.value = null
    }


    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}