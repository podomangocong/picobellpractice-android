package com.picobell.app.repository.category

import com.picobell.app.model.Category
import com.picobell.app.network.ApiClient
import com.picobell.app.repository.category.CategoryDataSource

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}