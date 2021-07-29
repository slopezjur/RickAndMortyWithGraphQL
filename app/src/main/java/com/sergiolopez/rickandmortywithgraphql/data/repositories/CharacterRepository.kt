package com.sergiolopez.rickandmortywithgraphql.data.repositories

import android.util.Log
import com.apollographql.apollo.api.Response
import com.sergiolopez.rickandmortywithgraphql.CharacterListQuery
import com.sergiolopez.rickandmortywithgraphql.data.datasources.LocalDataSource
import com.sergiolopez.rickandmortywithgraphql.data.datasources.RemoteDataSource
import com.sergiolopez.rickandmortywithgraphql.domain.Character

class CharacterRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getCharacters(): List<Character> {
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

        return localDataSource.getCharacters()
    }

    private fun mapGraphQlResponseToCharacters(
        response: Response<CharacterListQuery.Data>?
    ): List<Character> {

        val result = response?.data?.characters?.results?.filterNotNull()

        return if (result != null && !response.hasErrors()) {
            result.map { charactersListQuery ->
                Character(
                    charactersListQuery.image.orEmpty(),
                    charactersListQuery.name.orEmpty(),
                    charactersListQuery.species.orEmpty()
                )
            }
        } else emptyList()
    }

    suspend fun findById(id: Int): Character = localDataSource.findById(id)

    suspend fun update(character: Character) = localDataSource.update(character)
}

