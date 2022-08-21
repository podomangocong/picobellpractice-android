package com.picobell.app.repository.categorydetail

import com.picobell.app.model.CategoryDetail
import com.picobell.app.repository.category.CategoryRemoteDataSource

class CategoryDetailRepository(
    private val remoteDataSource: CategoryDetailRemoteSource
) {

    suspend fun getCategoryDetail(): CategoryDetail {
        return remoteDataSource.getCategoryDetail()
    }
}