package com.sergiolopez.rickandmortywithgraphql.framework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sergiolopez.rickandmortywithgraphql.databinding.CharacterListFragmentBinding

class CharacterListFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: CharacterListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharacterListFragmentBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.characters.observe(viewLifecycleOwner) { characters ->
            val characterAdapter = CharacterListAdapter(characters)

            binding.charactersRecycler.layoutManager = LinearLayoutManager(requireContext())
            binding.charactersRecycler.adapter = characterAdapter
        }

        viewModel.onCreate()
    }
}