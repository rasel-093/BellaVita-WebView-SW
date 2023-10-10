package com.example.bellavita.components
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(topTitle:String,scope: CoroutineScope,drawerState: DrawerState){
    TopAppBar(
        title = { Text(text = topTitle) },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch { drawerState.open() }
            }
            ) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Menu"
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor =  Color(0xFF14BEAE),
            titleContentColor = Color.White
        ),
    )
}