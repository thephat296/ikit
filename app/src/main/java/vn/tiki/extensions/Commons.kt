package vn.tiki.extensions

/**
 * make all case in sealed class will be handled
 */
val <T> T.exhaustive: T
    get() = this
