package com.fzellner.pokedex.data.entities

data class PokemonListDTO(
    val data: List<PokemonDTO>
)

data class PokemonDTO(
    val id:Int,
    val name:String,
    val type: List<String>,
    val image:String
)
