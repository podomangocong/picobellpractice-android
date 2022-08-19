package com.picobell.app.ui.common

import androidx.lifecycle.Observer

// 구글에서 공개한 앱 아키텍쳐 샘플을 참조함.

// 모든 데이터타입을 처리해야하므로 제네릭타입<T>, 생성자 content도 마찬가지로 제네릭타입
class Event<T>(private val content: T) {

    // 이 데이터가 소비되었는지 확인할 Boolean타입의 변수
    private var hasBeenHandled = false
    // hasBeenHandled가 false일때 content반환 -> false이면 아직 사용하지 않은 데이터라는 의미.
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null // hasBeenHandled가 true인 경우는 데이터를 사용하면 안되므로 null 반환
        } else {
            hasBeenHandled = true  // hasBeenHandled가 아직 소비되지 않았을 때는 true로 변환하고
            content // content를 사용할 수 있도록 반환
        }
    }
}

// LiveData의 데이터가 변경되었다는 알림을 받을때마다 getContentIfNotHandled메서드를 통해서 실제로 이 데이터가 소비되었었는지 확인해야한다. 이과정은 모든 LiveData타입이 거쳐야함.
// 이확인 과정을 대신 처리해주는 객체 EventObserver.
// Observer를 구현한 객체를 만들어서 observe메서드의 두번째 인자로 이벤트Observer를 구현해서 전달.
// 람다식을 만들어서 활용
 class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        // 위에서 만든 메서드를 활용해서 데이터가 사용되었는지 확인. 아닐때는 null을 반환하므로, null이 아닐때 반환하도록 ?.let
        event?.getContentIfNotHandled()?.let {
            onEventUnhandledContent(it)
        }
    }
}