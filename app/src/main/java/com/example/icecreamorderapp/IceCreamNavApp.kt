package com.example.icecreamorderapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun IceCreamNavApp(orderViewModel: OrderViewModel) {
    val navController = rememberNavController()
    val cartViewModel = remember { CartViewModel() }

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            IceCreamMenu(cartViewModel) {
                navController.navigate("cart")
            }
        }
        composable("cart") {
            CartScreen(cartViewModel, orderViewModel) {
                navController.navigate("menu")
            }
        }
        composable("history") {
            OrderHistoryScreen(orderViewModel) {
                navController.navigate("menu")
            }
        }
    }
}