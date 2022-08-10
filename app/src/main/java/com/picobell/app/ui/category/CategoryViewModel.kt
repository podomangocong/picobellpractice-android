package com.picobell.app.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picobell.app.model.Category
import com.picobell.app.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val categoryRepository: CategoryRepository
): ViewModel() {

    private val _items = MutableLiveData<List<Category>>()
    val items: LiveData<List<Category>> = _items

    init {
        loadCategory()
    }

    private fun loadCategory() {
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories //api를 통해서 받아온 데이터를 _items.value에 할당해서 업데이트한다.
        }
    }
}