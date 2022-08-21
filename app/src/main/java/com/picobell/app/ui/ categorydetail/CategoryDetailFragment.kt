package com.picobell.app.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.ConcatAdapter
import com.picobell.app.common.KEY_CATEGORY_ID
import com.picobell.app.common.KEY_CATEGORY_LABEL
import com.picobell.app.databinding.FragmentCategoryDetailBinding
import com.picobell.app.ui.common.ViewModelFactory

class CategoryDetailFragment : Fragment() {

    private lateinit var binding: FragmentCategoryDetailBinding
    private val viewModel: CategoryDetailViewModel by viewModels { ViewModelFactory(requireContext())} // ViewModel에 저장한 데이터를 Fragment에서 사용가능.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setListAdapter()


    }

    // Toolbar를 셋업
    private fun setToolbar() {
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title =
            categoryLabel // categoryLabel은 Appbar영역에 text로 보여주려했으므로 toolbar에 직접 저근해서 title을 전달받은 데이터로 할당.
    }


    // ListAdapter를 구성하는 부분이므로 따로 메서드로 추가해서 구현.
    // 두 개의 Adapter : CategoryPromotionAdapter, CategorySectionTitleAdapter를 연결해준다.
    private fun setListAdapter() {
        val titleAdapter = CategorySectionTitleAdapter()
        val promotionAdapter = CategoryPromotionAdapter()
        binding.rvCategoryDetail.adapter = ConcatAdapter(titleAdapter, promotionAdapter) // rvCategoryDetail(fragment_category_detail레이아웃)에 두 개의 Adapter를 할당.
        viewModel.promotions.observe(viewLifecycleOwner) { promotions ->
            titleAdapter.submitList(listOf(promotions.title)) // 데이터 List타입으로 전달해야하기 listOf의 인자로 데이터를 추가.
            promotionAdapter.submitList(promotions.items)
        }
    }
}

