package com.example.mobileappcyna

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mobileappcyna.ui.theme.MobileAppCynaTheme
import com.example.mobileappcyna.ui.view.WebView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileAppCynaTheme {
                WebView()
            }
        }
    }
}
