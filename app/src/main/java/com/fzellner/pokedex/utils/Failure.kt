package com.fzellner.pokedex.utils

open class Failure: Throwable(){
    object NetworkException: Throwable()
    object ServerError: Throwable()
    object ClientError: Throwable()
    object GenericError: Throwable()
}
