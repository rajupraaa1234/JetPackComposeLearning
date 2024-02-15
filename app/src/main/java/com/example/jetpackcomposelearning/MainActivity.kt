package com.example.jetpackcomposelearning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposelearning.Api.TweestyApi
import com.example.jetpackcomposelearning.Utility.Pages
import com.example.jetpackcomposelearning.screens.CardDetails
import com.example.jetpackcomposelearning.screens.CardListingScreen
import com.example.jetpackcomposelearning.screens.CategoryScreen
import com.example.jetpackcomposelearning.screens.DetailsScreen
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
            Log.d("Response",response.body()!!.distinct().toString())
        }
        setContent {
           App()
            //CategoryScreen()
            //DetailsScreen()
        }
    }

}

@Composable
fun App(){
   val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category"){
        composable(route="category"){
            CategoryScreen{
                navController.navigate("detail/${it}")
            }
        }
        composable(
            route = "detail/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) {
            DetailsScreen()
        }



    }
}


