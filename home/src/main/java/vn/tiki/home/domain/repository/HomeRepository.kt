package vn.tiki.home.domain.repository

import vn.tiki.home.domain.model.BannerDomainModel

/**
 * Created by phatvt2 on 8/5/20
 */

interface HomeRepository {
    suspend fun getBanners(): List<BannerDomainModel>
}