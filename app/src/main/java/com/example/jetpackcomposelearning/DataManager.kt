package com.example.jetpackcomposelearning

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.jetpackcomposelearning.Utility.Pages
import com.example.jetpackcomposelearning.models.Cards
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Cards>();
    var isDataLoaded = mutableStateOf(false);
    var currentCard: Cards? = null
    var currentPages = mutableStateOf(Pages.LISTING);
    fun loadAssetsFromFile(context : Context){
        var inputStream = context.assets.open("cardsData.json");
        var size:Int = inputStream.available()
        var buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Cards>::class.java)
        isDataLoaded.value = true;
    }

    fun switchPages(cards: Cards?){
            if(currentPages.value == Pages.LISTING){
                currentCard = cards
                currentPages.value  = Pages.DETAILS
            }else{
                currentPages.value  = Pages.LISTING
            }
    }
}