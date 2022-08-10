package com.picobell.app.repository

import com.picobell.app.model.Category
import com.picobell.app.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource  {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}