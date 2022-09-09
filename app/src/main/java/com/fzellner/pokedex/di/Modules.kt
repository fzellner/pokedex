package com.fzellner.pokedex.di

import com.fzellner.pokedex.data.api.PokemonService
import com.fzellner.pokedex.data.api.RetrofitIntegration
import com.fzellner.pokedex.data.repository.PokemonListRepository
import com.fzellner.pokedex.data.repository.PokemonListRepositoryImpl
import com.fzellner.pokedex.interactor.GetPokemon
import com.fzellner.pokedex.ui.list.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


object Modules {

    private val retrofitModule  = module {
        single {
            RetrofitIntegration.builder(PokemonService::class.java)
        }
    }

    private val repositories  = listOf( module {
        factory<PokemonListRepository> {
            PokemonListRepositoryImpl(get())
        }
    })

    private val useCases  = listOf( module {
        factory { GetPokemon(get()) }
    })

    private val viewModels = listOf(module {
        viewModel { PokemonListViewModel(get()) }
    })

    fun modules(): List<Module> {
        val modules  =  mutableListOf<Module>()

        modules.add(retrofitModule)
        modules.addAll(repositories)
        modules.addAll(useCases)
        modules.addAll(viewModels)

        return modules
    }

}