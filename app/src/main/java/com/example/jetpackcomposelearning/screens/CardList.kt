package com.example.jetpackcomposelearning.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.jetpackcomposelearning.models.Cards

@Composable
fun CardList(data : Array<Cards>,onClick : (cards : Cards)->Unit){
    LazyColumn(content = {
        items(data){
            CardListItem(cards = it,onClick)
        }
    })
}