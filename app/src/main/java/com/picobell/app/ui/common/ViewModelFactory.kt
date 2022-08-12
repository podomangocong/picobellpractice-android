package com.picobell.app.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.picobell.app.AssetLoader
import com.picobell.app.network.ApiClient
import com.picobell.app.repository.CategoryRemoteDataSource
import com.picobell.app.repository.CategoryRepository
import com.picobell.app.repository.HomeAssetDataSource
import com.picobell.app.repository.HomeRepository
import com.picobell.app.ui.category.CategoryViewModel
import com.picobell.app.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                 HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                 val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                 CategoryViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}