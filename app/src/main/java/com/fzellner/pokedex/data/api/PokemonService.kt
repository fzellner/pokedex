package com.fzellner.pokedex.data.api

import com.fzellner.pokedex.data.entities.PokemonListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun getListPokemon(@Query("offset") offset:Int,@Query("limit") limit:Int) : PokemonListDTO
}