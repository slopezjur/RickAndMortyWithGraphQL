package com.sergiolopez.rickandmortywithgraphql.framework.data.datasources

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.sergiolopez.rickandmortywithgraphql.CharacterListQuery
import com.sergiolopez.rickandmortywithgraphql.data.apolloClient
import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource

class ServerCharacterDataSource : RemoteDataSource {
    override suspend fun getCharacters(): Response<CharacterListQuery.Data> {
        return apolloClient.query(CharacterListQuery()).await()
    }
}