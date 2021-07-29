package com.sergiolopez.rickandmortywithgraphql.framework.data.database

import com.sergiolopez.rickandmortywithgraphql.data.datasources.LocalDataSource
import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter

class RoomDataSource : LocalDataSource {

    private var charactersList = listOf<UniverseCharacter>()

    override suspend fun isEmpty(): Boolean {
        //TODO("Not yet implemented")
        return true
    }

    override suspend fun saveCharacters(universeCharacters: List<UniverseCharacter>) {
        //TODO("Not yet implemented")
        charactersList = universeCharacters
    }

    override suspend fun getCharacters(): List<UniverseCharacter> {
        //TODO("Not yet implemented")
        return charactersList
    }

    override suspend fun findById(id: Int): UniverseCharacter {
        //TODO("Not yet implemented")
        return UniverseCharacter("", "", "")
    }

    override suspend fun update(movie: UniverseCharacter) {
        //TODO("Not yet implemented")
    }
}