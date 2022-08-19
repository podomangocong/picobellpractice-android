package com.picobell.app.common

// 이 파일을 따로 생성해준 이유는 category_id,category_label key값들은 CategoryFragment와 CategoryDetailFragment에서 모두 사용하므로
// 변수에 저장해서 따로 관리하면 좋겠다 판단. 그러면 key값이 변경되었을때 여기서 수정하면 두 곳에 한번에 변경되는게 편하므로.
// 프로젝트 전역에서 사용할 수 있는 상수값은 따로 파일에 모아두는게 편하다.
const val KEY_CATEGORY_ID = "category_id"
const val KEY_CATEGORY_LABEL = "category_label"

