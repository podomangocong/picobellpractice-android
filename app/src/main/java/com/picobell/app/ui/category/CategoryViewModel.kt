package com.picobell.app.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picobell.app.model.Category
import com.picobell.app.repository.CategoryRepository
import com.picobell.app.ui.common.Event
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val categoryRepository: CategoryRepository
): ViewModel() {

    private val _items = MutableLiveData<List<Category>>()
    val items: LiveData<List<Category>> = _items

    // 아이템이 선택되었는지 여부를 저장하는 데이터를 추가
    private val _openCategoryEvent = MutableLiveData<Event<Category>>() // 외부에 비공개하고 수정가능한 타입의 LiveData
    val openCategoryEvent: LiveData<Event<Category>> = _openCategoryEvent // 외부에 공개하고 수정불가능한 타입 LiveData

    init {
        loadCategory()
    }

    // 사용자가 카테고리의 아이템을 선택하면 _openCategoryEvent의 값을 새로 업데이트하는 메서드
    fun openCategoryDetail(category: Category) {
        _openCategoryEvent.value = Event(category)
    }

    private fun loadCategory() {
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories //api를 통해서 받아온 데이터를 _items.value에 할당해서 업데이트한다.
        }
    }
}