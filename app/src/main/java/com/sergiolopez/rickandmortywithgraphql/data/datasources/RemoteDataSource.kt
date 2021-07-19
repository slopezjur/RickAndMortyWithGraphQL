package com.sergiolopez.rickandmortywithgraphql.data.datasources

import com.apollographql.apollo.api.Response
import com.sergiolopez.rickandmortywithgraphql.CharacterListQuery

interface RemoteDataSource {

    suspend fun getCharacters(): Response<CharacterListQuery.Data>
}