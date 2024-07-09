package com.example.wb_homework

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.wb_homework.ui.screens.MainScreen
import com.example.wb_homework.ui.theme.Wb_homeworkTheme
import com.example.wb_homework.ui.ui_kit.MySplashScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Wb_homeworkTheme {
                val splashScreenVisible = remember { mutableStateOf(true) }
                LaunchedEffect(key1 = Unit) {
                    delay(2000) 
                    splashScreenVisible.value = false
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    if (splashScreenVisible.value) {
                        MySplashScreen()
                    } else {
                        MainScreen()
                    }
                }
            }
        }
    }
}
