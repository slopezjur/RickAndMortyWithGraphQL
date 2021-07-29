package com.sergiolopez.rickandmortywithgraphql.data.datasources

import com.sergiolopez.rickandmortywithgraphql.domain.Character

interface LocalDataSource {

    suspend fun isEmpty(): Boolean
    suspend fun saveCharacters(characters: List<Character>)
    suspend fun getCharacters(): List<Character>
    suspend fun findById(id: Int): Character
    suspend fun update(movie: Character)
}