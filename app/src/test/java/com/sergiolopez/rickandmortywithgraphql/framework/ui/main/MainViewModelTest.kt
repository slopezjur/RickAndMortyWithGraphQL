package com.sergiolopez.rickandmortywithgraphql.framework.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.sergiolopez.rickandmortywithgraphql.domain.UniverseCharacter
import com.sergiolopez.rickandmortywithgraphql.usescases.GetUniverseCharacters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @Mock
    lateinit var getUniverseCharacters: GetUniverseCharacters

    @Mock
    lateinit var observerUniverseCharacterList: Observer<List<UniverseCharacter>>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun onCreateLoadsCharacter() {
        runBlocking {
            val characterList = listOf(
                UniverseCharacter("imagen1", "name1", "species1"),
                UniverseCharacter("imagen2", "name2", "species2")
            )

            val characterFlow = flow {
                emit(characterList)
            }

            `when`(getUniverseCharacters.load()).thenReturn(characterFlow)

            val vm = MainViewModel(getUniverseCharacters)
            vm.characters.observeForever(observerUniverseCharacterList)

            vm.onCreate()

            verify(observerUniverseCharacterList).onChanged(characterList)
        }
    }
}