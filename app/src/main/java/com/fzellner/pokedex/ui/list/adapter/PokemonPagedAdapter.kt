package com.fzellner.pokedex.ui.list.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.fzellner.pokedex.R
import com.fzellner.pokedex.databinding.AdapterItemPokemonBinding
import com.fzellner.pokedex.domain.model.Pokemon
import com.fzellner.pokedex.domain.model.PokemonType

class PokemonPagedAdapter : PagingDataAdapter<Pokemon, PokemonPagedAdapter.PokemonViewHolder>(
    DiffCallback()
) {

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let {
            holder.setIsRecyclable(false)
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding =
            AdapterItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    class DiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }

    class PokemonViewHolder(private val item: AdapterItemPokemonBinding) :
        RecyclerView.ViewHolder(item.root) {

        fun bind(pokemon: Pokemon) {
            val context = item.root.context
            item.nameTextView.text = pokemon.name.replaceFirstChar { it.uppercase() }
            item.pokemonImageView.load(pokemon.image){ crossfade(true) }
            item.numberTextview.text =  String.format("#%03d", pokemon.id)

            val mainType = pokemon.type.first()
            val secondaryType = pokemon.type.takeIf { it.size > 1 }?.get(1)

            item.infoConstraintLayout.background =
                mapBackground(context, mainType ?: PokemonType.NORMAL)

            mainType?.let {
                setMainType(context, it)
            } ?: run {
                item.mainType.visibility = View.GONE
            }

            secondaryType?.let {
                setSecondartType(context, it)
            } ?: run {
                item.secondaryType.visibility = View.GONE
            }
        }

        private fun setMainType(context: Context, type: PokemonType) {
            item.mainType.setCardBackgroundColor(mapBackgroundColor(context, type))
            item.mainTypeIcon.setImageDrawable(mapTypeIcon(context, type))
            item.mainTypeTextView.text = type.typeName
        }

        private fun setSecondartType(context: Context, type: PokemonType) {
            item.secondaryType.setCardBackgroundColor(mapBackgroundColor(context, type))
            item.secondaryTypeIcon.setImageDrawable(mapTypeIcon(context, type))
            item.secondaryTypeTextView.text = type.typeName
        }

        private fun mapBackground(context: Context, pokemonType: PokemonType) =
            ContextCompat.getDrawable(context, pokemonType.background)

        private fun mapBackgroundColor(context: Context, pokemonType: PokemonType?): Int =
            ContextCompat.getColor(
                context,
                when (pokemonType) {
                    PokemonType.BUG -> R.color.type_bug_color
                    PokemonType.DARK -> R.color.type_dark_color
                    PokemonType.DRAGON -> R.color.type_dragon_color
                    PokemonType.ELETRIC -> R.color.type_eletric_color
                    PokemonType.FAIRY -> R.color.type_fairy_color
                    PokemonType.FIGHTER -> R.color.type_fighting_color
                    PokemonType.FIRE -> R.color.type_fire_color
                    PokemonType.FLYING -> R.color.type_flying_color
                    PokemonType.GHOST -> R.color.type_ghost_color
                    PokemonType.GRASS -> R.color.type_grass_color
                    PokemonType.GROUND -> R.color.type_ground_color
                    PokemonType.ICE -> R.color.type_ice_color
                    PokemonType.NORMAL -> R.color.type_normal_color
                    PokemonType.POISON -> R.color.type_poison_color
                    PokemonType.PSYCHIC -> R.color.type_pyschic_color
                    PokemonType.ROCK -> R.color.type_rock_color
                    PokemonType.STEEL -> R.color.type_steel_color
                    PokemonType.WATER -> R.color.type_water_color
                    null -> 0
                }
            )

        private fun mapTypeIcon(context: Context, type: PokemonType): Drawable? =
            ContextCompat.getDrawable(
                context,
                type.typeIcon
            )
    }
}