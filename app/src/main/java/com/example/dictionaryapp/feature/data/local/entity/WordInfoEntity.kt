package com.example.dictionaryapp.feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapp.feature.domain.model.Meaning
import com.example.dictionaryapp.feature.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val origin: String,
    val meanings: List<Meaning>,

    @PrimaryKey
    val id: Int? = null
) {
    fun toWordInfo(): WordInfo {

        return WordInfo(
            meanings = meanings,
            word = word,
            origin = origin,
            phonetic = phonetic
        )

    }

}
