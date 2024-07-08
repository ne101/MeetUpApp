package com.example.wb_homework.ui.theme.ui_kit

import androidx.compose.runtime.Composable
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun MySplashScreen() {
    val composition =
        rememberLottieComposition(
            spec = LottieCompositionSpec.Asset("splash_screen3.json")
        )
    LottieAnimation(composition = composition.value)
}