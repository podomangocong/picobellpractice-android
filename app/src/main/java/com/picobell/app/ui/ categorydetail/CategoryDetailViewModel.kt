package com.picobell.app.ui.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picobell.app.model.Promotion
import com.picobell.app.model.TopSelling
import com.picobell.app.repository.categorydetail.CategoryDetailRepository
import kotlinx.coroutines.launch

class CategoryDetailViewModel(
    private val categoryDetailRepository: CategoryDetailRepository
    ): ViewModel() {


    // Repository에서 반환하는 categroryDetail의 topSelling과 promotion데이터를 UI로 그려야하므로
    // 받은 데이터 각각을 변수에 저장 (LiveData타입)
    private val _topSelling = MutableLiveData<TopSelling>() // 내부 수정용
    val topSelling: LiveData<TopSelling> = _topSelling // 외부 공개용

    private val _promotions = MutableLiveData<Promotion>()
    val promotions: LiveData<Promotion> = _promotions

    init {
        loadCategoryDetail()
    }

    private fun loadCategoryDetail() {
        // getCategoryDetail메서드는 코루틴scope 내부에서만 요청하도록 강제했으므로 viewModelScope.launch를 사용함.
        viewModelScope.launch {
            // getCategoryDetail을 통해서 데이터를 변수 categoryDetail에 할당
            val categoryDetail = categoryDetailRepository.getCategoryDetail()
            // 위의 변수에 데이터를 업데이트
            _topSelling.value = categoryDetail.topSelling
            _promotions.value = categoryDetail.promotions
        }
    }
}