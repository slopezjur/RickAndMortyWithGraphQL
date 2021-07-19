package com.sergiolopez.rickandmortywithgraphql.usescases

import android.util.Log
import com.apollographql.apollo.coroutines.await
import com.sergiolopez.rickandmortywithgraphql.data.apolloClient
import com.sergiolopez.rickandmortywithgraphql.CharacterListQuery
import com.sergiolopez.rickandmortywithgraphql.domain.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoadCharacters {

    suspend fun load(): List<Character> = withContext(Dispatchers.IO) {
        val response = try {
            apolloClient.query(CharacterListQuery()).await()
        } catch (ex: Exception) {
            Log.d("CharacterList", "Failure", ex)
            null
        }

        val result = response?.data?.characters?.results?.filterNotNull()

        if (result != null && !response.hasErrors()) {
            result.map { charactersListQuery ->
                Character(
                    charactersListQuery.image.orEmpty(),
                    charactersListQuery.name.orEmpty(),
                    charactersListQuery.species.orEmpty()
                )
            }
        } else emptyList()
    }
}