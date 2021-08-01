package com.sergiolopez.rickandmortywithgraphql.framework.data.server

import com.apollographql.apollo.api.Response
import com.sergiolopez.rickandmortywithgraphql.UniverseCharacterListQuery

interface UniverseCharacterRemoteServer {

    suspend fun listUniverseCharacters(): Response<UniverseCharacterListQuery.Data>
}