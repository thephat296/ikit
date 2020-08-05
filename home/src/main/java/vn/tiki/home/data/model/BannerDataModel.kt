package vn.tiki.home.data.model

import com.google.gson.annotations.SerializedName
import vn.tiki.home.domain.model.BannerDomainModel

/**
 * Created by phatvt2 on 8/5/20
 */

data class BannerDataModel(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("url") val url: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
    @SerializedName("mobile_url") val mobileUrl: String,
    @SerializedName("ratio") val ratio: Float
) {
    fun toDomainModel() = BannerDomainModel(id, title, content, url, imageUrl, thumbnailUrl, mobileUrl, ratio)
}