package vn.tiki.home.data.model

import com.google.gson.annotations.SerializedName
import vn.tiki.home.domain.model.QuickLinkDomainModel

/**
 * Created by phatvt2 on 8/5/20
 */

data class QuickLinkDataModel(
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("url") val url: String,
    @SerializedName("authentication") val authentication: Boolean,
    @SerializedName("web_url") val webUrl: String,
    @SerializedName("image_url") val imageUrl: String
) {
    fun toDomainModel() = QuickLinkDomainModel(title, content, url, authentication, webUrl, imageUrl)
}