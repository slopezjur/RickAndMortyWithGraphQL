package com.sergiolopez.rickandmortywithgraphql.data.repositories

import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource

class CharacterRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getCharacters() = remoteDataSource.getCharacters()
}

