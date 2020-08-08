package vn.tiki.home.domain.usecase

import vn.tiki.domain.model.Result
import vn.tiki.home.domain.model.BannerDomainModel
import vn.tiki.home.domain.repository.HomeRepository
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/5/20
 */

class GetBannersUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<BannerDomainModel>> =
        try {
            Result.Success(homeRepository.getBanners())
        } catch (e: Exception) {
            Result.Error(e)
        }
}