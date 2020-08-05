package vn.tiki.home.domain.model

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
)