package com.sergiolopez.rickandmortywithgraphql.usescases

import com.sergiolopez.rickandmortywithgraphql.data.repositories.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UsescasesModule {

    @Provides
    fun remoteDataSourceProvider(characterRepository: CharacterRepository): ILoadCharacters =
        LoadCharacters(characterRepository)
}