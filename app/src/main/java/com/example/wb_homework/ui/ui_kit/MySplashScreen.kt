package com.example.wb_homework.ui.ui_kit

import androidx.compose.runtime.Composable
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
internal fun MySplashScreen() {
    val composition =
        rememberLottieComposition(
            spec = LottieCompositionSpec.Asset("splash_screen3.json")
        )
    LottieAnimation(composition = composition.value)
}