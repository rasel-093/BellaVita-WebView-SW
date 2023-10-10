package com.example.bellavita.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Warning

val drawerItems: List<NavigationDrawerItem> = listOf<NavigationDrawerItem>(
    NavigationDrawerItem(
        title = "All",
        selectedIcon = Icons.Outlined.Home,
        unSelectedIcon = Icons.Default.Home
    ),
    NavigationDrawerItem(
        title = "About",
        selectedIcon = Icons.Outlined.Info,
        unSelectedIcon = Icons.Default.Info
    ),
    NavigationDrawerItem(
        title = "Disclaimer",
        selectedIcon = Icons.Outlined.Warning,
        unSelectedIcon = Icons.Default.Warning
    )
)