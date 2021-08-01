package com.sergiolopez.rickandmortywithgraphql.data.repositories

import android.util.Log
import com.apollographql.apollo.api.Response
import com.sergiolopez.rickandmortywithgraphql.UniverseCharacterListQuery
import com.sergiolopez.rickandmortywithgraphql.data.datasources.LocalDataSource
import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UniverseCharacterRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getUniverseCharacters(): Flow<List<UniverseCharacter>> = flow {
        if (localDataSource.isEmpty()) {
            val response = try {
                remoteDataSource.getUniverseCharacters()
            } catch (ex: Exception) {
                Log.d("UniverseCharacterList", "Failure", ex)
                null
            }

            val universeCharacters = mapGraphQlResponseToUniverseCharacters(response)

            localDataSource.saveUniverseCharacters(universeCharacters)
        }

        emit(localDataSource.getUniverseCharacters())
    }

    private fun mapGraphQlResponseToUniverseCharacters(
        response: Response<UniverseCharacterListQuery.Data>?
    ): List<UniverseCharacter> {

        val result = response?.data?.characters?.results?.filterNotNull()

        return if (result != null && !response.hasErrors()) {
            result.map { charactersListQuery ->
                UniverseCharacter(
                    charactersListQuery.image.orEmpty(),
                    charactersListQuery.name.orEmpty(),
                    charactersListQuery.species.orEmpty()
                )
            }
        } else emptyList()
    }

    suspend fun findById(id: Int): UniverseCharacter = localDataSource.findById(id)

    suspend fun update(universeCharacter: UniverseCharacter) =
        localDataSource.update(universeCharacter)
}

