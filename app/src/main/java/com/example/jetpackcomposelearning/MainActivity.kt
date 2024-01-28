package com.example.jetpackcomposelearning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collection.mutableVectorOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposelearning.ui.theme.JetPackComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayItem()
//            JetPackComposeLearningTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Heasdasllo $name!",
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        color = Color.Blue,
        fontSize = 30.sp
    )
}

@Composable
fun ImageCom() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Image",
        colorFilter = ColorFilter.tint(Color.Blue),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ButtonCom() {
    Button(
        onClick = { Log.d("Home", "Click") },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
        ),
        enabled = true
    ) {
        Text(text = "Click")
    }
}

@Composable
fun InputFeild() {
    val text = remember { mutableStateOf("") }
    TextField(value = text.value, onValueChange = {
            text.value = it
    },
       label = { Text(text = "Enter Name")}
    )
}

@Composable
fun VerticleAlignment() {
    Column(verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)
    }
}

@Composable
fun HorizontalAlignment() {
    Row(
       horizontalArrangement = Arrangement.Center,
       verticalAlignment = Alignment.CenterVertically

    ) {
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)
    }
}


@Composable
fun renderItem() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Image",
            Modifier.size(102.dp),
            colorFilter = ColorFilter.tint(Color.Gray),
            contentScale = ContentScale.Crop,
            
        )
        Column(
            modifier = Modifier.background(Color.Cyan)
                .clickable { Log.d("click ","On Text") }
                .padding(10.dp)
                .fillMaxWidth()

        ) {

            Text(text = "Software Developer", fontSize = 14.sp)
            Text(text = "Raju kumar", fontSize = 10.sp)
        }
    }
}


@Preview(showBackground = true, widthDp = 300 , heightDp = 600)
@Composable
fun GreetingPreview() {
//    ButtonCom()
//    InputFeild();
    //VerticleAlignment();
    //HorizontalAlignment()
    renderItem();
    //ImageCom()
    //Greeting("raju")
}

