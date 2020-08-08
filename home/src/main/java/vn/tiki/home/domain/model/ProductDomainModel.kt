package vn.tiki.home.domain.model

/**
 * Created by phatvt2 on 8/9/20
 */

data class ProductDomainModel(
    val id: Long,
    val name: String,
    val urlPath: String,
    val price: Long,
    val discount: Long,
    val thumbnailUrl: String
)