package com.sergiolopez.rickandmortywithgraphql.framework.data.server

import com.apollographql.apollo.api.Response
import com.sergiolopez.rickandmortywithgraphql.CharacterListQuery

interface CharacterRemoteServer {

    suspend fun listCharacters(): Response<CharacterListQuery.Data>
}