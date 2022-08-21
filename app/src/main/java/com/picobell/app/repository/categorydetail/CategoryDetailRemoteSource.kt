package com.picobell.app.repository.categorydetail

import com.picobell.app.model.CategoryDetail
import com.picobell.app.network.ApiClient

class CategoryDetailRemoteSource(private val api: ApiClient): CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
       return api.getCategoryDetail()
    }
}