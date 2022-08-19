package com.picobell.app.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.picobell.app.databinding.ItemCategoryBinding
import com.picobell.app.model.Category

class CategoryAdapter(private val viewModel: CategoryViewModel): ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.viewModel = viewModel // CategoryAdapter 생성자로 viewModel을 받아서 가능하고 그러려면 CategoryAdapter의 inner클래스 선언을 해줘야한다. (그래야 생성자를 가져와서 사용할 수 있으니)
            binding.category = category
            binding.executePendingBindings()
        }
    }

}

class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}