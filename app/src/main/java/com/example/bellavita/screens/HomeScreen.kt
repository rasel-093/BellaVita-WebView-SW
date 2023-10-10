package com.example.bellavita.screens

import androidx.compose.runtime.Composable
import com.example.bellavita.components.webView

@Composable
fun homeScreen(){
    webView(url = "https://portal.bellavitapellets.com/dosage/")
}