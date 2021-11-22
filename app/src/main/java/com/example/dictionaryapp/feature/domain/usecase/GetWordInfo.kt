package com.example.dictionaryapp.feature.domain.usecase

import com.example.dictionaryapp.core.util.Resource
import com.example.dictionaryapp.feature.domain.model.WordInfo
import com.example.dictionaryapp.feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {

        if (word.isBlank()) {
            return flow { }

        }

        return repository.getWordInfo(word)
    }

}
