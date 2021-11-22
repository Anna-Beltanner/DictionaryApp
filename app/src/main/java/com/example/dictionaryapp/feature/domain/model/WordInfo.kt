package com.example.dictionaryapp.feature.domain.model

import com.example.dictionaryapp.feature.data.remote.dto.MeaningDto
import com.example.dictionaryapp.feature.data.remote.dto.PhoneticDto

data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)
