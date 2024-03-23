package com.example.jetpackcomposelearning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        CoroutineScope(Dispatchers.IO).launch {   // for Performance purpose
//            DataManager.loadAssetsFromFile(applicationContext);
//        }
       // var count =  mutableStateOf(0)
        //var count by mutableStateOf(0)
        var count = 0
        fun setCounter(){
            count = count+1
            Log.d("TAG", "setCounter: ${count}")
        }
        setContent {
            val viewModel = viewModel<ViweModelClass>(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return ViweModelClass(
                            name = "Vikash kumar"
                        ) as T
                    }
                }
            )
            App(viewModel)
        }
    }
}


//@Preview
@Composable
fun App(viewModel: ViweModelClass) {
   val TAG :  String   =  "ViweModelClass"
    Log.d(TAG, "App: again run ${viewModel.customName}")
   // var count : Int = 0;
   // var count =  mutableStateOf(0)
    //val isLiked: MutableState<Boolean> = mutableStateOf(false),
    //val count : MutableState<Int> = remember { mutableStateOf(0) };
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "${viewModel.customName}",
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color.Blue,
            fontSize = 30.sp
        )

//        fun setCounter(){
//            count = count+1
//            Log.d("TAG", "setCounter: ${count}")
//        }
        Button(onClick = {viewModel.changeUserName()},modifier = Modifier.padding(10.dp)) {
            Text(text = "Click")
        }
    }

}

@Composable
fun CounterExample() {
    var counter by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Counter: $counter", style = MaterialTheme.typography.bodyMedium)
        Button(
            onClick = {
                // Simulating a delay in updating the counter
                //Thread.sleep(1000)
                counter++
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = "Increment Counter")
        }
    }
}


