package com.example.phraseapp.di

import com.example.phraseapp.data.ApiService
import com.example.phraseapp.data.PhraseRepository
import com.example.phraseapp.domain.GetPhraseUseCase
import dagger.Module
import dagger.Provides
import dagger.Component
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://declarance.ru") // Замените на базовый URL вашего API
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providePhraseRepository(apiService: ApiService): GetPhraseUseCase {
        return PhraseRepository(apiService)
    }
}

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getPhraseUseCase(): GetPhraseUseCase
}