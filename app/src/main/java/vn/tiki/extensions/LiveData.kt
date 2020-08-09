package vn.tiki.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by phatvt2 on 8/9/20
 */

fun <T> LiveData<T>.safeObserve(fragment: Fragment, observer: Observer<in T>) {
    observe(fragment.viewLifecycleOwner, observer)
}