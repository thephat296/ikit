package vn.tiki.home.data.model

import com.google.gson.annotations.SerializedName
import vn.tiki.home.domain.model.FlashDealDomainModel

/**
 * Created by phatvt2 on 8/8/20
 */

data class FlashDealDataModel(
    @SerializedName("status") val status: String,
    @SerializedName("url") val url: String,
    @SerializedName("tags") val tags: String,
    @SerializedName("discount_percent") val discountPercent: Float,
    @SerializedName("special_price") val specialPrice: Long,
    @SerializedName("special_from_date") val specialFromDate: Long,
    @SerializedName("from_date") val fromDate: String,
    @SerializedName("special_to_date") val specialToDate: Long
) {
    fun toDomainModel() =
        FlashDealDomainModel(status, url, tags, discountPercent, specialPrice, specialFromDate, fromDate, specialToDate)
}

