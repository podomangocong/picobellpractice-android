package com.picobell.app.ui.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.fragment.findNavController
import com.picobell.app.R
import com.picobell.app.common.KEY_CATEGORY_ID
import com.picobell.app.common.KEY_CATEGORY_LABEL
import com.picobell.app.databinding.FragmentCategoryBinding
import com.picobell.app.model.Category
import com.picobell.app.ui.common.EventObserver
import com.picobell.app.ui.common.ViewModelFactory

class CategoryFragment:Fragment() {

    private val viewModel: CategoryViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryAdapter = CategoryAdapter(viewModel)
        binding.rvCategoryList.adapter = categoryAdapter
        viewModel.items.observe(viewLifecycleOwner) {
           categoryAdapter.submitList(it)
        }

        // observe메서드를 이용해서 viewModel의 openCategoryEvent의 상태가 변경됨을 알림받고
        viewModel.openCategoryEvent.observe(viewLifecycleOwner, EventObserver{
            openCategoryDetail(it.categoryId, it.label) // 상태가 변경되면( 카테고리가 하나 선택되면) openCategoryDetail를 호출
        })
    }

    //  CategoryDetailFragment이동할 때 전달할 데이터 category_id, category_label 2가지
    private fun openCategoryDetail(categoryId: String,categoryLabel: String) { // value값 categoryId와 categoryLabel을 파라미터로 받는다.
        findNavController().navigate(R.id.action_category_to_category_detail, bundleOf(
            KEY_CATEGORY_ID to categoryId,
            KEY_CATEGORY_LABEL to categoryLabel
        ))
    }
}