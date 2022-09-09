package com.fzellner.pokedex.interactor

import androidx.paging.PagingData
import com.fzellner.pokedex.data.repository.PokemonListRepository
import com.fzellner.pokedex.domain.model.Pokemon
import com.fzellner.pokedex.utils.GetUseCase
import kotlinx.coroutines.flow.Flow

class GetPokemon(private val repository: PokemonListRepository) :
    GetUseCase<PagingData<Pokemon>>() {
    override fun run(): Flow<PagingData<Pokemon>> {
        return repository.getPokemonList()
    }
}