package com.sergiolopez.rickandmortywithgraphql.framework.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.sergiolopez.rickandmortywithgraphql.domain.Character
import com.sergiolopez.rickandmortywithgraphql.usescases.ILoadCharacters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
    lateinit var loadCharacters: ILoadCharacters

    @Mock
    lateinit var observerCharacterList: Observer<List<Character>>

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
                Character("imagen1", "name1", "species1"),
                Character("imagen2", "name2", "species2")
            )
            `when`(loadCharacters.load()).thenReturn(characterList)

            val vm = MainViewModel(loadCharacters)
            vm.characters.observeForever(observerCharacterList)

            vm.onCreate()

            verify(observerCharacterList).onChanged(characterList)
        }
    }
}