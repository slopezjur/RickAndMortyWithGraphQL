package com.sergiolopez.rickandmortywithgraphql.framework.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter
import com.sergiolopez.rickandmortywithgraphql.usescases.GetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCharacters: GetCharacters
) : ViewModel() {

    private val _characters = MutableLiveData<List<UniverseCharacter>>()
    val characters: LiveData<List<UniverseCharacter>> get() = _characters

    fun onCreate() {
        viewModelScope.launch {
            _characters.value = getCharacters.load()
        }
    }

    fun onCharacterClicked(universeCharacter: UniverseCharacter) {
        // TODO : not impelementd
    }
}