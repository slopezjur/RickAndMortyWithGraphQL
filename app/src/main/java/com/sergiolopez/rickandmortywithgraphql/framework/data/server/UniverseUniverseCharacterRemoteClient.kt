package com.sergiolopez.rickandmortywithgraphql.framework.data.server

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.sergiolopez.rickandmortywithgraphql.UniverseCharacterListQuery

class UniverseUniverseCharacterRemoteClient(baseUrl: String): UniverseCharacterRemoteServer {

    private val apolloClient: ApolloClient = ApolloClient.builder()
        .serverUrl(baseUrl)
        .build()

    override suspend fun listUniverseCharacters(): Response<UniverseCharacterListQuery.Data> {
        return apolloClient.query(UniverseCharacterListQuery()).await()
    }
}