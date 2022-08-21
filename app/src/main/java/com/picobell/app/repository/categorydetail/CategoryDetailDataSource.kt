package com.picobell.app.repository.categorydetail

import com.picobell.app.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail
}