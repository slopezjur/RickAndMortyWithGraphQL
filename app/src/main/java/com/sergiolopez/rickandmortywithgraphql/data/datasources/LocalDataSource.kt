package com.sergiolopez.rickandmortywithgraphql.data.datasources

import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter

interface LocalDataSource {

    suspend fun isEmpty(): Boolean
    suspend fun saveUniverseCharacters(universeCharacters: List<UniverseCharacter>)
    suspend fun getUniverseCharacters(): List<UniverseCharacter>
    suspend fun findById(id: Int): UniverseCharacter
    suspend fun update(movie: UniverseCharacter)
}