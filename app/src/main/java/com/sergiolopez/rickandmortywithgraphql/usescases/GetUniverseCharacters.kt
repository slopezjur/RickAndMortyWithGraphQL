package com.sergiolopez.rickandmortywithgraphql.usescases

import com.sergiolopez.rickandmortywithgraphql.data.repositories.UniverseCharacterRepository
import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUniverseCharacters @Inject constructor(
    private val universeCharacterRepository: UniverseCharacterRepository
) {
    suspend fun load(): Flow<List<UniverseCharacter>> =
        universeCharacterRepository.getUniverseCharacters()
}