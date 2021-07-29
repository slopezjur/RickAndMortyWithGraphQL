package com.sergiolopez.rickandmortywithgraphql.framework.data.database

import com.sergiolopez.rickandmortywithgraphql.data.datasources.LocalDataSource
import com.sergiolopez.rickandmortywithgraphql.domain.Character

class RoomDataSource : LocalDataSource {

    private var charactersList = listOf<Character>()

    override suspend fun isEmpty(): Boolean {
        //TODO("Not yet implemented")
        return true
    }

    override suspend fun saveCharacters(characters: List<Character>) {
        //TODO("Not yet implemented")
        charactersList = characters
    }

    override suspend fun getCharacters(): List<Character> {
        //TODO("Not yet implemented")
        return charactersList
    }

    override suspend fun findById(id: Int): Character {
        //TODO("Not yet implemented")
        return Character("", "", "")
    }

    override suspend fun update(movie: Character) {
        //TODO("Not yet implemented")
    }
}