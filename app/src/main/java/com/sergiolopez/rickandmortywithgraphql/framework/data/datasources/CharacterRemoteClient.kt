package com.sergiolopez.rickandmortywithgraphql.framework.data.datasources

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.sergiolopez.rickandmortywithgraphql.CharacterListQuery

class CharacterRemoteClient(baseUrl: String): CharacterRemoteServer {

    private val apolloClient: ApolloClient = ApolloClient.builder()
        .serverUrl(baseUrl)
        .build()

    override suspend fun listCharacters(): Response<CharacterListQuery.Data> {
        return apolloClient.query(CharacterListQuery()).await()
    }
}