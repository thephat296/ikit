package vn.tiki.home.presentation.ui.type

import androidx.annotation.IntDef
import vn.tiki.home.presentation.ui.type.HomeItemViewType.Companion.BANNERS
import vn.tiki.home.presentation.ui.type.HomeItemViewType.Companion.FLASH_DEALS
import vn.tiki.home.presentation.ui.type.HomeItemViewType.Companion.LOADING
import vn.tiki.home.presentation.ui.type.HomeItemViewType.Companion.QUICK_LINKS

/**
 * Created by phatvt2 on 8/6/20
 */

@IntDef(LOADING, BANNERS, QUICK_LINKS, FLASH_DEALS)
@Retention(AnnotationRetention.SOURCE)
annotation class HomeItemViewType {
    companion object {
        const val LOADING = 0
        const val BANNERS = 1
        const val QUICK_LINKS = 2
        const val FLASH_DEALS = 3
    }
}