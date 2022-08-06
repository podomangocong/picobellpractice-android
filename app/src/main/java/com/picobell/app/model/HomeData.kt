package com.picobell.app.model

import com.google.gson.annotations.SerializedName
import com.picobell.app.Banner

data class HomeData(
    val title: Title,
    @SerializedName("top_banners") val topBanners: List<Banner>
)
