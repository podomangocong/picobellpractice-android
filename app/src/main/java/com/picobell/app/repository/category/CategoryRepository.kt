package com.picobell.app.repository.category

import com.picobell.app.model.Category
import com.picobell.app.repository.category.CategoryRemoteDataSource

class CategoryRepository(
    private val remoteDataSource: CategoryRemoteDataSource
) {

    suspend fun getCategories(): List<Category> {
        return remoteDataSource.getCategories()
    }
}