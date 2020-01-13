package com.ardakazanci.mvvmexercise_1.ui.photos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ardakazanci.mvvmexercise_1.R
import com.ardakazanci.mvvmexercise_1.databinding.ItemPhotosBinding
import com.ardakazanci.mvvmexercise_1.model.Photos
import com.ardakazanci.mvvmexercise_1.ui.photos.PhotosViewModel

class PhotosListAdapter : RecyclerView.Adapter<PhotosListAdapter.ViewHolder>() {

    private lateinit var photosList: List<Photos>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding: ItemPhotosBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_photos,
            parent,
            false
        )
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return if (::photosList.isInitialized) photosList.size else 0
    }

    // Position with photosList Data bind ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photosList[position])
    }

    fun updatePostList(photosList: List<Photos>) {
        this.photosList = photosList
        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ItemPhotosBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val viewModel = PhotosViewModel()

        fun bind(post: Photos) {
            viewModel.bind(post)
            binding.viewModel = viewModel
        }

    }

}