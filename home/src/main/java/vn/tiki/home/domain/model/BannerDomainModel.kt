package vn.tiki.home.domain.model

import vn.tiki.home.presentation.ui.model.BannerItem

/**
 * Created by phatvt2 on 8/5/20
 */

data class BannerDomainModel(
    val id: Long,
    val title: String,
    val content: String,
    val url: String,
    val imageUrl: String,
    val thumbnailUrl: String,
    val mobileUrl: String,
    val ratio: Float
) {
    fun toBannerItem() = BannerItem(id, title, content, url, imageUrl, thumbnailUrl, mobileUrl, ratio)
}