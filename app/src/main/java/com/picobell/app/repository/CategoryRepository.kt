package com.picobell.app.repository

import com.picobell.app.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository(
    private val remoteDataSource: CategoryRemoteDataSource
) {

    suspend fun getCategories(): List<Category> {
        return remoteDataSource.getCategories()
    }
}