package com.sergiolopez.rickandmortywithgraphql.framework.ui.main

import com.sergiolopez.rickandmortywithgraphql.data.repositories.UniverseCharacterRepository
import com.sergiolopez.rickandmortywithgraphql.usescases.GetUniverseCharacters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainActivityModule {

    @Provides
    fun loadCharacterProvider(universeCharacterRepository: UniverseCharacterRepository) =
        GetUniverseCharacters(universeCharacterRepository)
}