package com.picobell.app.repository.category

import com.picobell.app.model.Category

interface CategoryDataSource {

   suspend fun getCategories(): List<Category>
}