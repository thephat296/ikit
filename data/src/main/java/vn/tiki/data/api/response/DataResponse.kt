package vn.tiki.data.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by phatvt2 on 8/5/20
 */

data class DataResponse<T>(@SerializedName("data") var data: T?)
