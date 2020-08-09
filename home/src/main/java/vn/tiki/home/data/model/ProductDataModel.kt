package vn.tiki.home.data.model

import com.google.gson.annotations.SerializedName
import vn.tiki.home.domain.model.ProductDomainModel

/**
 * Created by phatvt2 on 8/9/20
 */

data class ProductDataModel(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String?,
    @SerializedName("url_path") val urlPath: String?,
    @SerializedName("price") val price: Long,
    @SerializedName("discount") val discount: Long,
    @SerializedName("thumbnail_url") val thumbnailUrl: String?
) {
    @Throws(IllegalArgumentException::class)
    fun toDomainModel(): ProductDomainModel {
        requireNotNull(name)
        requireNotNull(urlPath)
        requireNotNull(thumbnailUrl)
        return ProductDomainModel(id, name, urlPath, price, discount, thumbnailUrl)
    }
}