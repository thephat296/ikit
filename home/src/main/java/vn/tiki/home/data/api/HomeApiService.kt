package vn.tiki.home.data.api

import retrofit2.http.GET
import vn.tiki.home.data.model.BannerDataModel

/**
 * Created by phatvt2 on 8/5/20
 */

interface HomeApiService {
    @GET(PATH_GET_BANNER)
    suspend fun getBanners(): DataResponse<List<BannerDataModel>>
}