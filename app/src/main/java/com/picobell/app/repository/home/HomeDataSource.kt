package com.picobell.app.repository.home

import com.picobell.app.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}