package com.sergiolopez.rickandmortywithgraphql.framework.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergiolopez.rickandmortywithgraphql.domain.Character
import com.sergiolopez.rickandmortywithgraphql.usescases.ILoadCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loadCharacters: ILoadCharacters
) : ViewModel() {

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