package com.example.bellavita.data

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bellavita.components.bottomBar
import com.example.bellavita.components.topBar
import com.example.bellavita.screens.accountScreen
import com.example.bellavita.screens.dosageScreen
import com.example.bellavita.screens.homeScreen
import com.example.bellavita.screens.orderScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navigationComponents(){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val navController = rememberNavController()
    var title by rememberSaveable {
        mutableStateOf("")
    }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                drawerItems.forEachIndexed{ index, item->
                    NavigationDrawerItem(
                        label = { Text(text = item.title ) },
                        selected = index == selectedItemIndex,
                        onClick = {
                            //navController.navigate(item.route)
                            selectedItemIndex = index
                            scope.launch { drawerState.close() }
                        },
                        icon = {
                            if(index == selectedItemIndex){item.selectedIcon}
                            else {item.unSelectedIcon}
                        },

                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)
                            .width(200.dp)
                    )
                }
            }
        },
        drawerState = drawerState,
        gesturesEnabled = false
    ) {
        Scaffold(
            topBar = {topBar(
                topTitle = title,
                scope = scope,
                drawerState = drawerState
            )
            },
            bottomBar = { bottomBar(navController = navController )},
            content = {paddingValues ->
                //navHost(navController = navController)
                NavHost(
                    navController = navController,

                    // set the start destination as home
                    startDestination = "dosage",

                    // Set the padding provided by scaffold
                    modifier = Modifier.padding(paddingValues = paddingValues),

                    builder = {

                        // route : Home
                        composable("home") {
                            homeScreen()
                            title = "Home"
                        }

                        // route : dosage
                        composable("dosage") {
                            dosageScreen()
                            title = "Dosage"
                        }

                        // route : order
                        composable("order") {
                            orderScreen()
                            title = "Order"
                        }

                        // route : account
                        composable("account") {
                            accountScreen()
                            title = "Account"
                        }
                    })
            }
        )
    }
}