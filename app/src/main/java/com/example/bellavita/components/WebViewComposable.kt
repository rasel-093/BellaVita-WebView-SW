package com.example.bellavita.components;

import android.graphics.Bitmap
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun webView(url: String){
    var backEnabled by remember{
        mutableStateOf(false)
    }
    var webView: WebView? = null

    AndroidView(
        modifier = Modifier
            .fillMaxSize(),
        factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                webViewClient = object : WebViewClient(){
                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        if (view != null) {
                            backEnabled = view.canGoBack()
                        }
                    }
                }
                settings.javaScriptEnabled = true
                // settings.userAgentString = System.getProperty("http.agent")
                settings.loadsImagesAutomatically = true
                loadUrl(url)
                webView = this
            }
        },
        update = {
            webView = it
        }
    )
    BackHandler (enabled = backEnabled){
        webView?.goBack()
    }
}