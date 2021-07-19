package com.sergiolopez.rickandmortywithgraphql.framework.ui.main

import com.sergiolopez.rickandmortywithgraphql.data.repositories.CharacterRepository
import com.sergiolopez.rickandmortywithgraphql.usescases.LoadCharacters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainActivityModule {

    @Provides
    fun loadCharacterProvider(characterRepository: CharacterRepository) =
        LoadCharacters(characterRepository)
}