package vn.tiki.domain.model

/**
 * Created by phatvt2 on 8/5/20
 */

sealed class Result<out T : Any> {
    class Success<out T : Any>(val data: T) : Result<T>()

    class Error(val exception: Throwable) : Result<Nothing>()
}
