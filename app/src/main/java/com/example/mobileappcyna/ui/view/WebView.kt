package com.example.mobileappcyna.ui.view

import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.Modifier



@Composable
fun WebView (){

    val context = LocalContext.current

    val URL by remember {mutableStateOf("https://anthonydeschaseaux.alwaysdata.net")}
    //val URL by remember {mutableStateOf("https://fr.wikipedia.org/wiki/Wikip%C3%A9dia:Accueil_principal")}

    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    val webView = remember {
        android.webkit.WebView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webViewClient = android.webkit.WebViewClient()

            //load the web view
            loadUrl(URL)
        }
    }

    DisposableEffect(webView) {
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (webView.canGoBack()){
                    webView.goBack()
                }
            }
        }
        onBackPressedDispatcher?.addCallback(callback)

        onDispose { callback.remove() }
    }

    // the view

    AndroidView(
        factory = {webView},
        modifier = Modifier.fillMaxSize()
    )



}