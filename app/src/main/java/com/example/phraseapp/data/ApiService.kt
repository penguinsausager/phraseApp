package com.example.phraseapp.data

import retrofit2.http.GET

interface ApiService {
    @GET("/api/juke") // Замените на конечный адрес вашего API
    suspend fun getPhrase(): PhraseResponse
}

data class PhraseResponse(val phrase: String) // Это соответствует структуре JSON ответа