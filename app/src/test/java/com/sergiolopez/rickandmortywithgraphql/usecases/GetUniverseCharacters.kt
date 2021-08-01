package com.sergiolopez.rickandmortywithgraphql.usecases

import com.sergiolopez.rickandmortywithgraphql.data.repositories.UniverseCharacterRepository
import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter
import com.sergiolopez.rickandmortywithgraphql.usescases.GetUniverseCharacters
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetUniverseCharacters {

    lateinit var getUniverseCharacters: GetUniverseCharacters

    @Mock
    lateinit var universeCharacterRepository: UniverseCharacterRepository

    @Before
    fun setUp() {
        getUniverseCharacters = GetUniverseCharacters(universeCharacterRepository)
    }

    @Test
    fun whenGetCharacters_shouldLoadCharactersList() {
        runBlocking {
            val characterFlow = flow {
                emit(
                    listOf(
                        UniverseCharacter("imagen1", "name1", "species1"),
                        UniverseCharacter("imagen2", "name2", "species2")
                    )
                )
            }

            `when`(getUniverseCharacters.load()).thenReturn(characterFlow)

            val result = getUniverseCharacters.load()

            Assert.assertEquals(characterFlow, result)
        }
    }
}