package com.picobell.app.model

import com.google.gson.annotations.SerializedName
import com.picobell.app.Product

data class CategoryDetail(
    @SerializedName("top_selling") val topSelling: TopSelling,
    val promotions: Promotion
)

data class TopSelling(
    val title: Title,
    val categories: List<Category>
)

data class Promotion(
    val title: Title,
    val items: List<Product>
)