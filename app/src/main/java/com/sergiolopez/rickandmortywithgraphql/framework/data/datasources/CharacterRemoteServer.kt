package com.sergiolopez.rickandmortywithgraphql.framework.data.datasources

import com.apollographql.apollo.api.Response
import com.sergiolopez.rickandmortywithgraphql.CharacterListQuery

interface CharacterRemoteServer {

    suspend fun listCharacters(): Response<CharacterListQuery.Data>
}