package com.example.phraseapp.data

import com.example.phraseapp.domain.GetPhraseUseCase
import javax.inject.Inject

class PhraseRepository @Inject constructor(
    private val apiService: ApiService // Это будет наш Retrofit API клиент
) : GetPhraseUseCase {
    override suspend fun execute(): String {
        val response = apiService.getPhrase() // вызываем запрос к API
        return response.phrase
    }
}