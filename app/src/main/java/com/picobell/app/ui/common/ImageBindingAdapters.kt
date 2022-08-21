package com.picobell.app.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.picobell.app.GlideApp

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }
}

// 이미지뷰에서 이 커스텀속성을 호출하면 이미지를 원형으로 렌더링할 수 있음.
@BindingAdapter("circleImageUrl")
fun loadCircleImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        GlideApp.with(view)
            .load(imageUrl)
            .circleCrop()
            .into(view)
    }
}