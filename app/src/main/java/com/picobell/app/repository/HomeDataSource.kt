package com.picobell.app.repository

import com.picobell.app.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}