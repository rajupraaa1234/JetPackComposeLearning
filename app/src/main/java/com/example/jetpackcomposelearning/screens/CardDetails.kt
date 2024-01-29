package com.example.jetpackcomposelearning.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposelearning.DataManager
import com.example.jetpackcomposelearning.models.Cards


@Composable
fun CardDetails(cards: Cards) {
    BackHandler {
        DataManager.switchPages(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3),
                    )
                )
            )
    ) {
        Card(
            modifier = Modifier
                .padding(32.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp,

                ),

            ) {
            Box(modifier = Modifier.background(Color.White)) {
                Column(
                    verticalArrangement = Arrangement.Center, modifier = Modifier
                        .padding(20.dp)
                ) {
                    Image(
                        imageVector = Icons.Filled.Favorite,
                        colorFilter = ColorFilter.tint(Color.White),
                        alignment = Alignment.TopStart,
                        contentDescription = "Card",
                        modifier = Modifier
                            .size(50.dp)
                            .background(Color.Blue)
                            .padding(5.dp)
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = cards.text,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.4f)
                            .height(1.dp)
                            .background(Color(0xFFEEEEEE))
                    )
                    Text(
                        text = cards.author,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Thin,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }

}