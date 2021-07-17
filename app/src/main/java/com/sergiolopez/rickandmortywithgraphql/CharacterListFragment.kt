package com.sergiolopez.rickandmortywithgraphql

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.apollographql.apollo.coroutines.await
import com.sergiolopez.rickandmortywithgraphql.databinding.CharacterListFragmentBinding
import java.lang.Exception

class CharacterListFragment : Fragment() {

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

        lifecycleScope.launchWhenResumed {
            val response = try {
                apolloClient.query(CharacterListQuery()).await()
            } catch (ex: Exception) {
                Log.d("CharacterList", "Failure", ex)
                null
            }

            val characters = response?.data?.characters?.results?.filterNotNull()

            if(characters != null && !response.hasErrors()) {
                val adapter = CharacterListAdapter(characters)
                binding.characters.layoutManager = LinearLayoutManager(requireContext())
                binding.characters.adapter = adapter
            }
        }
    }
}