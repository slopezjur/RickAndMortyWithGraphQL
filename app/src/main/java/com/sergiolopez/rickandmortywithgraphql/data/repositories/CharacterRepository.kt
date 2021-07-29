package com.sergiolopez.rickandmortywithgraphql.data.repositories

import android.util.Log
import com.apollographql.apollo.api.Response
import com.sergiolopez.rickandmortywithgraphql.CharacterListQuery
import com.sergiolopez.rickandmortywithgraphql.data.datasources.LocalDataSource
import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getCharacters(): Flow<List<UniverseCharacter>> = flow {
        if (localDataSource.isEmpty()) {
            val response = try {
                remoteDataSource.getCharacters()
            } catch (ex: Exception) {
                Log.d("CharacterList", "Failure", ex)
                null
            }

            val characters = mapGraphQlResponseToCharacters(response)

            localDataSource.saveCharacters(characters)
        }

        emit(localDataSource.getCharacters())
    }

    private fun mapGraphQlResponseToCharacters(
        response: Response<CharacterListQuery.Data>?
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

