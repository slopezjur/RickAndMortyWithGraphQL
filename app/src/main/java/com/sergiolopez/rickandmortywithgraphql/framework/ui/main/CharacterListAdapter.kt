package com.sergiolopez.rickandmortywithgraphql.framework.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sergiolopez.rickandmortywithgraphql.databinding.CharacterItemBinding
import com.sergiolopez.rickandmortywithgraphql.domain.Character

class CharacterListAdapter(
    private val characters: List<Character>
) : RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    class ViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.binding.characterImage.load(character.image)
        holder.binding.characterName.text = character.name
        holder.binding.characterSpecies.text = character.species
    }
}