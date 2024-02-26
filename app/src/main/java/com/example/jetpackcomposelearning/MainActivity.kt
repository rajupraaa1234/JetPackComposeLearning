package com.example.jetpackcomposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {   // for Performance purpose
            DataManager.loadAssetsFromFile(applicationContext);
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    Text(
        text = "Heasdasllo Android!",
        modifier = Modifier.padding(20.dp),
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        color = Color.Blue,
        fontSize = 30.sp
    )
}


