package com.picobell.app.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import com.picobell.app.common.KEY_CATEGORY_ID
import com.picobell.app.common.KEY_CATEGORY_LABEL
import com.picobell.app.databinding.FragmentCategoryDetailBinding

class CategoryDetailFragment : Fragment() {

    private lateinit var binding: FragmentCategoryDetailBinding

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
    }
}

