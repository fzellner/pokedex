package com.fzellner.pokedex.ui.list.adapter

import android.content.Context
import androidx.core.content.ContextCompat
import com.fzellner.pokedex.R
import com.fzellner.pokedex.domain.model.PokemonType

class PokemonBackgroundMapper {
    fun mapBackground(context: Context, pokemonType: PokemonType) =
        when (pokemonType) {
            PokemonType.BUG -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_bug_backgrond
            )
            PokemonType.DARK -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_dark_backgrond
            )
            PokemonType.DRAGON -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_dragon_backgrond
            )
            PokemonType.ELETRIC -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_electric_backgrond
            )
            PokemonType.FAIRY -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_fairy_backgrond
            )
            PokemonType.FIGHTER -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_fighter_backgrond
            )
            PokemonType.FIRE -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_fire_backgrond
            )
            PokemonType.FLYING -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_flying_backgrond
            )
            PokemonType.GHOST -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_ghost_backgrond
            )
            PokemonType.GRASS -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_grass_backgrond
            )
            PokemonType.GROUND -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_ground_backgrond
            )
            PokemonType.ICE -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_ice_backgrond
            )
            PokemonType.NORMAL -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_normal_backgrond
            )
            PokemonType.POISON -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_poison_backgrond
            )
            PokemonType.PSYCHIC -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_psychic_backgrond
            )
            PokemonType.ROCK -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_rock_backgrond
            )
            PokemonType.STEEL -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_steel_backgrond
            )
            PokemonType.WATER -> ContextCompat.getDrawable(
                context,
                R.drawable.pokemon_item_water_backgrond
            )
        }
}