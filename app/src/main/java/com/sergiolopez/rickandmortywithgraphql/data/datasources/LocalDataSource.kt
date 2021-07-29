package com.sergiolopez.rickandmortywithgraphql.data.datasources

import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter

interface LocalDataSource {

    suspend fun isEmpty(): Boolean
    suspend fun saveCharacters(universeCharacters: List<UniverseCharacter>)
    suspend fun getCharacters(): List<UniverseCharacter>
    suspend fun findById(id: Int): UniverseCharacter
    suspend fun update(movie: UniverseCharacter)
}