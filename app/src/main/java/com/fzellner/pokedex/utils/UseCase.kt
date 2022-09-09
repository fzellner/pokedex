package com.fzellner.pokedex.utils

import kotlinx.coroutines.flow.Flow


abstract class UseCase<in Params, out Type> {
    abstract fun run(params: Params): Flow<Type>

    operator fun invoke(params: Params): Flow<Type> {
        return run(params)
    }
}


abstract class GetUseCase<out Type> {
    abstract fun run(): Flow<Type>

    operator fun invoke(): Flow<Type> {
        return run()
    }
}