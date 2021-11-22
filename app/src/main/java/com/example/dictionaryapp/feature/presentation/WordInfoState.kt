package com.example.dictionaryapp.feature.presentation

import android.text.BoringLayout
import com.example.dictionaryapp.feature.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false

    )
