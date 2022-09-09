package com.fzellner.pokedex.data.repository

import androidx.paging.*
import com.fzellner.pokedex.data.api.PokemonService
import com.fzellner.pokedex.data.entities.PokemonDTO
import com.fzellner.pokedex.domain.model.Pokemon
import com.fzellner.pokedex.domain.model.PokemonType
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException

const val networkPageSize = 10


class PokemonListRepositoryImpl(private val service: PokemonService) : PokemonListRepository {
    override fun getPokemonList(): Flow<PagingData<Pokemon>> {

        return Pager(
            config = PagingConfig(
                pageSize = networkPageSize,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PokemonDataSource() }
        ).flow

    }

    inner class PokemonDataSource : PagingSource<Int, Pokemon>() {

        private val initialOffset = 0
        private val initialLoadSize = 1

        override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
            return null
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
            val position = params.key ?: initialLoadSize
            val offset = if (params.key != null) ((position - 1) * networkPageSize)  else initialOffset

            return try {
                val response = service.getListPokemon(offset = offset, limit = params.loadSize)
                val result = mapPokemonDto(response.data)
                val nextKey =
                    if (result.isNullOrEmpty()) null else position + (params.loadSize / networkPageSize)

                LoadResult.Page(
                    data = result,
                    prevKey = null,
                    nextKey = nextKey
                )


            } catch (ex: IOException) {
                return LoadResult.Error(ex)
            } catch (httpException: HttpException) {
                return LoadResult.Error(httpException)
            }

        }
    }

    private fun mapPokemonDto(data: List<PokemonDTO>): List<Pokemon> {
        return data.map {
            Pokemon(
                it.id,
                it.name,
                it.image,
                mapPokemonType(it.type)
            )
        }
    }

    private fun mapPokemonType(type: List<String>): List<PokemonType?> {
        return type.map {
            when (it.lowercase()) {
                NORMAL -> PokemonType.NORMAL
                FIRE -> PokemonType.FIRE
                WATER -> PokemonType.WATER
                ELETRIC -> PokemonType.ELETRIC
                GRASS -> PokemonType.GRASS
                ICE -> PokemonType.ICE
                FIGHTER -> PokemonType.FIGHTER
                POISON -> PokemonType.POISON
                GROUND -> PokemonType.GROUND
                FLYING -> PokemonType.FLYING
                PSYCHIC -> PokemonType.PSYCHIC
                BUG -> PokemonType.BUG
                ROCK -> PokemonType.ROCK
                GHOST -> PokemonType.GHOST
                DRAGON -> PokemonType.DRAGON
                DARK -> PokemonType.DARK
                STEEL -> PokemonType.STEEL
                FAIRY -> PokemonType.FAIRY
                else -> null
            }
        }
    }

    companion object {
        const val NORMAL = "normal"
        const val FIRE = "fire"
        const val WATER = "water"
        const val ELETRIC = "electric"
        const val GRASS = "grass"
        const val ICE = "ice"
        const val FIGHTER = "fighting"
        const val POISON = "poison"
        const val GROUND = "ground"
        const val FLYING = "flying"
        const val PSYCHIC = "psychic"
        const val BUG = "bug"
        const val ROCK = "rock"
        const val GHOST = "ghost"
        const val DRAGON = "dragon"
        const val DARK = "dark"
        const val STEEL = "steel"
        const val FAIRY = "fairy"
    }

}


