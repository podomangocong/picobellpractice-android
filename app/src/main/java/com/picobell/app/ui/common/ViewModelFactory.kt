package com.picobell.app.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.picobell.app.AssetLoader
import com.picobell.app.network.ApiClient
import com.picobell.app.repository.category.CategoryRemoteDataSource
import com.picobell.app.repository.category.CategoryRepository
import com.picobell.app.repository.categorydetail.CategoryDetailRemoteSource
import com.picobell.app.repository.categorydetail.CategoryDetailRepository
import com.picobell.app.repository.home.HomeAssetDataSource
import com.picobell.app.repository.home.HomeRepository
import com.picobell.app.ui.category.CategoryViewModel
import com.picobell.app.ui.categorydetail.CategoryDetailViewModel
import com.picobell.app.ui.home.HomeViewModel
// ViewModel의 생성을 위임받은 클래스
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
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository = CategoryDetailRepository(CategoryDetailRemoteSource(ApiClient.create()))
                CategoryDetailViewModel(repository) as T
            }

            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}