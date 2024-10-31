package com.example.phraseapp.domain

interface GetPhraseUseCase {
    suspend fun execute(): String
}