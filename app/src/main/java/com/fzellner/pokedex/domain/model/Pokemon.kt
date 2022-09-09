package com.fzellner.pokedex.domain.model

import com.fzellner.pokedex.R

data class Pokemon(
    val id: Int,
    val name: String,
    val image:String,
    val type: List<PokemonType?>
)


enum class PokemonType(val typeName:String, val background:Int, val typeIcon: Int) {
    NORMAL("Normal", R.drawable.pokemon_item_normal_backgrond, R.drawable.ic_normal_type_svg),
    FIRE ("Fire", R.drawable.pokemon_item_fire_backgrond, R.drawable.ic_fire_type_svg),
    WATER ("Water", R.drawable.pokemon_item_water_backgrond, R.drawable.ic_water_type_svg),
    ELETRIC ("Eletric", R.drawable.pokemon_item_electric_backgrond, R.drawable.ic_electric_type_svg),
    GRASS ("Grass", R.drawable.pokemon_item_grass_backgrond, R.drawable.ic_grass_type_svg),
    ICE ("Ice", R.drawable.pokemon_item_ice_backgrond, R.drawable.ic_ice_type_svg),
    FIGHTER ("Fighter", R.drawable.pokemon_item_fighter_backgrond, R.drawable.ic_fighter_type_svg),
    POISON ("Poison", R.drawable.pokemon_item_poison_backgrond, R.drawable.ic_poison_type_svg),
    GROUND ("Ground", R.drawable.pokemon_item_ground_backgrond, R.drawable.ic_ground_type_svg),
    FLYING ("Flying", R.drawable.pokemon_item_flying_backgrond, R.drawable.ic_flying_type_svg),
    PSYCHIC ("Psychic", R.drawable.pokemon_item_psychic_backgrond, R.drawable.ic_psychic_type_svg),
    BUG ("Bug", R.drawable.pokemon_item_bug_backgrond, R.drawable.ic_type_bug_svg),
    ROCK ("Rock", R.drawable.pokemon_item_rock_backgrond, R.drawable.ic_rock_type_svg),
    GHOST ("Ghost", R.drawable.pokemon_item_ghost_backgrond, R.drawable.ic_ghost_type_svg),
    DRAGON ("Dragon", R.drawable.pokemon_item_dragon_backgrond, R.drawable.ic_dragon_type_svg),
    DARK ("Dark", R.drawable.pokemon_item_dark_backgrond, R.drawable.ic_type_dark_svg),
    STEEL ("Steel", R.drawable.pokemon_item_steel_backgrond, R.drawable.ic_steel_type_svg),
    FAIRY ("Fairy", R.drawable.pokemon_item_fairy_backgrond, R.drawable.ic_fairy_type_svg)
}

