package com.example.dictionaryapp.feature.domain.repository

import com.example.dictionaryapp.core.util.Resource
import com.example.dictionaryapp.feature.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}