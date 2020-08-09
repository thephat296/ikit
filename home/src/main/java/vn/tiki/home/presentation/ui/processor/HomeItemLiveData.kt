package vn.tiki.home.presentation.ui.processor

import androidx.lifecycle.MutableLiveData
import vn.tiki.home.presentation.ui.model.HomeItem
import java.util.*

/**
 * Created by phatvt2 on 8/9/20
 */

class HomeItemLiveData : MutableLiveData<List<HomeItem>>() {
    private val items = Vector<HomeItem>()

    fun set(data: HomeItem) {
        items.clear()
        items.add(data)
        postValue(items.toList())
    }

    fun add(data: HomeItem) {
        items.add(data)
        postValue(items.toList())
    }

    fun remove(data: HomeItem) {
        items.remove(data)
        postValue(items)
    }
}