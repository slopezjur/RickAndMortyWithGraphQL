package com.sergiolopez.rickandmortywithgraphql.framework.data.database

import com.sergiolopez.rickandmortywithgraphql.data.datasources.LocalDataSource
import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter

class RoomDataSource : LocalDataSource {

    private var universeCharactersList = listOf<UniverseCharacter>()

    override suspend fun isEmpty(): Boolean {
        //TODO("Not yet implemented")
        return true
    }

    override suspend fun saveUniverseCharacters(universeCharacters: List<UniverseCharacter>) {
        //TODO("Not yet implemented")
        universeCharactersList = universeCharacters
    }

    override suspend fun getUniverseCharacters(): List<UniverseCharacter> {
        //TODO("Not yet implemented")
        return universeCharactersList
    }

    override suspend fun findById(id: Int): UniverseCharacter {
        //TODO("Not yet implemented")
        return UniverseCharacter("", "", "")
    }

    override suspend fun update(movie: UniverseCharacter) {
        //TODO("Not yet implemented")
    }
}