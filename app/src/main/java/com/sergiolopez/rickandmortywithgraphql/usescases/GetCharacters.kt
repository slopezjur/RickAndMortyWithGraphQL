package com.sergiolopez.rickandmortywithgraphql.usescases

import com.sergiolopez.rickandmortywithgraphql.data.repositories.CharacterRepository
import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter
import javax.inject.Inject

class GetCharacters @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend fun load(): List<UniverseCharacter> = characterRepository.getCharacters()
}