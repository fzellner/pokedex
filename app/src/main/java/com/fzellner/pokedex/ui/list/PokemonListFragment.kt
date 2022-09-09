package com.fzellner.pokedex.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fzellner.pokedex.databinding.FragmentPokemonListBinding
import com.fzellner.pokedex.ui.list.adapter.PokemonPagedAdapter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel


class PokemonListFragment : Fragment() {

    private val viewModel by viewModel<PokemonListViewModel>()

    private lateinit var _binding: FragmentPokemonListBinding
    private lateinit var pokemonAdapter: PokemonPagedAdapter

    private val binding: FragmentPokemonListBinding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonListBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getPokemon().collectLatest {
                pokemonAdapter.submitData(it)
            }
        }

    }

    private fun setupAdapter() {

        pokemonAdapter = PokemonPagedAdapter()

        binding.pokemonRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pokemonAdapter
        }
    }


}