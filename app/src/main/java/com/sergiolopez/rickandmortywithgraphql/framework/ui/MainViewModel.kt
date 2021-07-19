package com.sergiolopez.rickandmortywithgraphql.framework.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergiolopez.rickandmortywithgraphql.data.repositories.CharacterRepository
import com.sergiolopez.rickandmortywithgraphql.domain.Character
import com.sergiolopez.rickandmortywithgraphql.usescases.LoadCharacters
import com.sergiolopez.rickandmortywithgraphql.framework.data.datasources.ServerCharacterDataSource
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val loadCharacters = LoadCharacters(
        CharacterRepository(
            ServerCharacterDataSource()
        )
    )

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> get() = _characters

    fun onCreate() {
        viewModelScope.launch {
            _characters.value = loadCharacters.load()
        }
    }

    fun onCharacterClicked(character: Character) {
        // TODO : not impelementd
    }
}