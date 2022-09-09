package com.fzellner.pokedex.data.repository

import androidx.paging.PagingData
import com.fzellner.pokedex.data.entities.PokemonDTO
import com.fzellner.pokedex.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {

    fun getPokemonList(): Flow<PagingData<Pokemon>>
}