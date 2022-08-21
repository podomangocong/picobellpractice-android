package com.picobell.app.repository.home

import com.picobell.app.model.HomeData
import com.picobell.app.repository.home.HomeAssetDataSource

class HomeRepository(
    private val assetDataSource: HomeAssetDataSource
) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}