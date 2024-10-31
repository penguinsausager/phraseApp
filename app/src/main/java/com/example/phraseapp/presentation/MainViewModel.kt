package com.example.phraseapp.presentation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phraseapp.domain.GetPhraseUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getPhraseUseCase: GetPhraseUseCase
) : ViewModel() {
    // Используем MutableLiveData для хранения фразы
    private val _phrase = MutableLiveData<String>()
    val phrase: LiveData<String> get() = _phrase  // Обеспечиваем доступ только для чтения

    fun fetchPhrase() {
        viewModelScope.launch {
            _phrase.value = getPhraseUseCase.execute()
        }
    }
}