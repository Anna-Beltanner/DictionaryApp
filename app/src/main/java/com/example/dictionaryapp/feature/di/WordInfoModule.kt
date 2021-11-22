package com.example.dictionaryapp.feature.di

import android.app.Application
import androidx.room.Room
import com.example.dictionaryapp.feature.data.local.Converters
import com.example.dictionaryapp.feature.data.local.WordInfoDao
import com.example.dictionaryapp.feature.data.local.WordInfoDatabase
import com.example.dictionaryapp.feature.data.remote.DictionaryApi
import com.example.dictionaryapp.feature.data.repository.WordInfoRepositoryImpl
import com.example.dictionaryapp.feature.data.util.GsonParser
import com.example.dictionaryapp.feature.domain.repository.WordInfoRepository
import com.example.dictionaryapp.feature.domain.usecase.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}