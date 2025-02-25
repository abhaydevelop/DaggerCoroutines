package com.example.daggerandcoroutines

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

data class NetworkStatus<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): NetworkStatus<T> {
            return NetworkStatus(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String): NetworkStatus<T> {
            return NetworkStatus(Status.ERROR, null, msg)
        }

        fun <T> loading(): NetworkStatus<T> {
            return NetworkStatus(Status.LOADING, null, null)
        }
    }
}