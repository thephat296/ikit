package vn.tiki.home.domain.repository

import vn.tiki.home.domain.model.BannerDomainModel
import vn.tiki.home.domain.model.QuickLinkDomainModel

/**
 * Created by phatvt2 on 8/5/20
 */

interface HomeRepository {
    suspend fun getBanners(): List<BannerDomainModel>

    suspend fun getQuickLinks(): List<List<QuickLinkDomainModel>>
}