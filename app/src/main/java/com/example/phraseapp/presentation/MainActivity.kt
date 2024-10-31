package com.example.phraseapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phraseapp.presentation.theme.PhraseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhraseAppTheme {
                val viewModel: MainViewModel = viewModel()
                viewModel.fetchPhrase() // Загружаем фразу при старте
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        phrase = viewModel.phrase.value ?: "Загрузка...",
                        modifier = Modifier.padding(innerPadding),
                        onRefresh = { viewModel.fetchPhrase() }
                    )
                }
            }
        }
    }

    @Composable
    fun Greeting(phrase: String, modifier: Modifier = Modifier, onRefresh: () -> Unit) {
        Text(
            text = phrase,
            modifier = modifier
        )
        Button(onClick = onRefresh) { // Добавляем кнопку
            Text(text = "Обновить фразу")
        }
    }
}

