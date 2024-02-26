package com.example.jetpackcomposelearning

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer : LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)   // Need to inform to Owner class on which point we need to call this method  (onDestroy,onResume,onStart)
                                                    // you can add any point in observer class. but first owner method will call then observer,
                                                    // for ex : Here i have declared on onCreate method so firstly owner/Activity onCrete method will call then observer method.
                                                    // But In case of onDestroy/back handler first observer method will call then Activity/owner method

    fun onCrete(){
        Log.d("Observer Called","Called")
    }
}