package com.sergiolopez.rickandmortywithgraphql.usescases

import android.util.Log
import com.sergiolopez.rickandmortywithgraphql.data.repositories.CharacterRepository
import com.sergiolopez.rickandmortywithgraphql.domain.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoadCharacters @Inject constructor (private val characterRepository: CharacterRepository) {

    suspend fun load(): List<Character> = withContext(Dispatchers.IO) {
        val response = try {
            characterRepository.getCharacters()
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