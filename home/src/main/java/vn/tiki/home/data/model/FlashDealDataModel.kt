package vn.tiki.home.data.model

import com.google.gson.annotations.SerializedName
import vn.tiki.home.domain.model.FlashDealDomainModel

/**
 * Created by phatvt2 on 8/8/20
 */

data class FlashDealDataModel(
    @SerializedName("discount_percent") val discountPercent: Float,
    @SerializedName("product") val product: ProductDataModel
) {
    fun toDomainModel() = FlashDealDomainModel(discountPercent, product.toDomainModel())
}

