package com.sergiolopez.rickandmortywithgraphql.usescases

import com.sergiolopez.rickandmortywithgraphql.domain.Character

interface ILoadCharacters {

    suspend fun load(): List<Character>
}