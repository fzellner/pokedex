package com.fzellner.pokedex.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fzellner.pokedex.domain.model.Pokemon
import com.fzellner.pokedex.interactor.GetPokemon
import kotlinx.coroutines.flow.Flow

class PokemonListViewModel(private val useCase: GetPokemon): ViewModel() {

    fun getPokemon() : Flow<PagingData<Pokemon>>{
        return useCase().cachedIn(viewModelScope)
    }
}