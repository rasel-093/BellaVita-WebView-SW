package com.example.bellavita.components
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bellavita.data.NavigationItems

@Composable
fun bottomBar(navController: NavController){

    NavigationBar(
        containerColor = Color(0xFFFCFCFC)
    ) {
        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        NavigationItems.forEach{ navItem->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route)
                    //topTitle = navItem.title
                },
                label = {
                    Text(text = navItem.title)
                },
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        imageVector = if (currentRoute == navItem.route){
                            navItem.selectedIcon
                        } else navItem.unSelectedIcon,
                        contentDescription = navItem.title
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF16AA9B),
                    selectedTextColor = Color(0xFF16AA9B),
                    indicatorColor = Color(0xFFFFFFFF),
                    unselectedTextColor = Color(0xFF161313)
                )
            )
        }
    }
}