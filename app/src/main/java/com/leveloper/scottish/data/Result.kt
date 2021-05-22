package com.leveloper.scottish.data

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class LvResult<out R> {

    override fun toString(): String {
        return when (this) {
            is LvSuccess<*> -> "Success[data=$data]"
            is LvError -> "Error[exception=$exception]"
            LvLoading -> "Loading"
        }
    }
}

data class LvSuccess<out T>(val data: T) : LvResult<T>()
data class LvError(val exception: Exception) : LvResult<Nothing>()
object LvLoading : LvResult<Nothing>()

/**
 * `true` if [Result] is of type [LvSuccess] & holds non-null [LvSuccess.data].
 */
val LvResult<*>.succeeded
    get() = this is LvSuccess && data != null