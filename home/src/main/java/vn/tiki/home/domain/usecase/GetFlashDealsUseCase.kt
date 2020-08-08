package vn.tiki.home.domain.usecase

import vn.tiki.home.domain.model.FlashDealDomainModel
import vn.tiki.home.domain.model.Result
import vn.tiki.home.domain.repository.HomeRepository
import javax.inject.Inject

/**
 * Created by phatvt2 on 8/8/20
 */

class GetFlashDealsUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<FlashDealDomainModel>> =
        try {
            Result.Success(homeRepository.getFlashDeals())
        } catch (e: Exception) {
            Result.Error(e)
        }
}