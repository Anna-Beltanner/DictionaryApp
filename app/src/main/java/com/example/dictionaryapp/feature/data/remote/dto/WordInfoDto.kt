package com.example.dictionaryapp.feature.data.remote.dto

import com.example.dictionaryapp.feature.data.local.entity.WordInfoEntity
import com.example.dictionaryapp.feature.domain.model.WordInfo



data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }
}