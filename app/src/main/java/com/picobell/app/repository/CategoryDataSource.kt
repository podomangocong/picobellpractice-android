package com.picobell.app.repository

import com.picobell.app.model.Category

interface CategoryDataSource {

   suspend fun getCategories(): List<Category>
}