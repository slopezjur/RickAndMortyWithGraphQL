package com.sergiolopez.rickandmortywithgraphql.data.datasources

import com.apollographql.apollo.api.Response
import com.sergiolopez.rickandmortywithgraphql.UniverseCharacterListQuery

interface RemoteDataSource {

    suspend fun getUniverseCharacters(): Response<UniverseCharacterListQuery.Data>
}