package com.example.bellavita.data
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart

val NavigationItems = listOf<BottomNavigationItem>(
    BottomNavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        route = "home"
    ),
    BottomNavigationItem(
        title = "Dosage",
        selectedIcon = Icons.Filled.Edit,
        unSelectedIcon = Icons.Outlined.Edit,
        route = "dosage"
    ),
    BottomNavigationItem(
        title = "Order",
        selectedIcon = Icons.Filled.ShoppingCart,
        unSelectedIcon = Icons.Outlined.ShoppingCart,
        route = "order"
    ),
    BottomNavigationItem(
        title = "Account",
        selectedIcon = Icons.Filled.AccountCircle,
        unSelectedIcon = Icons.Outlined.AccountCircle,
        route = "account"
    )
)