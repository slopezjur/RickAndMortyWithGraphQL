package com.sergiolopez.rickandmortywithgraphql.usecases

import com.sergiolopez.rickandmortywithgraphql.data.repositories.CharacterRepository
import com.sergiolopez.rickandmortywithgraphql.domain.Character
import com.sergiolopez.rickandmortywithgraphql.usescases.GetCharacters
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCharacters {

    lateinit var getCharacters: GetCharacters

    @Mock
    lateinit var characterRepository: CharacterRepository

    @Before
    fun setUp() {
        getCharacters = GetCharacters(characterRepository)
    }

    @Test
    fun whenGetCharacters_shouldLoadCharactersList() {
        runBlocking {
            val characterList = listOf(
                Character("imagen1", "name1", "species1"),
                Character("imagen2", "name2", "species2")
            )

            `when`(getCharacters.load()).thenReturn(characterList)

            val result = getCharacters.load()

            Assert.assertEquals(characterList, result)
        }
    }
}