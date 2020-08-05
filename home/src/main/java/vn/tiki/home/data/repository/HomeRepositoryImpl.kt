package vn.tiki.home.data.repository

import vn.tiki.home.data.api.HomeApiService
import vn.tiki.home.data.model.BannerDataModel
import vn.tiki.home.domain.model.BannerDomainModel
import vn.tiki.home.domain.repository.HomeRepository
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/5/20
 */

class HomeRepositoryImpl @Inject constructor(
    private val apiService: HomeApiService
) : HomeRepository {

    override suspend fun getBanners(): List<BannerDomainModel> =
        apiService
            .getBanners()
            .data!!
            .map(BannerDataModel::toDomainModel)
}