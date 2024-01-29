package com.example.jetpackcomposelearning.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposelearning.models.Cards

@Composable
fun CardListingScreen(data: Array<Cards>, onClick: (cards : Cards) -> Unit) {
    Column {
        Text(
            text = "Cards App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    8.dp, 24.dp
                )
                .fillMaxWidth()
        )
        CardList(data = data, onClick)
    }
}