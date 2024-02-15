package com.example.jetpackcomposelearning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.jetpackcomposelearning.Api.TweestyApi
import com.example.jetpackcomposelearning.Utility.Pages
import com.example.jetpackcomposelearning.screens.CardDetails
import com.example.jetpackcomposelearning.screens.CardListingScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tweestyApi: TweestyApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            var response = tweestyApi.getCategories();
            Log.d("Response",response.body().toString())
        }
        setContent {
            App()
        }
    }

}

@Composable
fun App(){
   if(DataManager.isDataLoaded.value){
       if(DataManager.currentPages.value == Pages.LISTING){
           CardListingScreen(data = DataManager.data) {
                DataManager.switchPages(it);
           }
       }else{
           DataManager.currentCard?.let { CardDetails(cards = it) }
       }

   }
}


