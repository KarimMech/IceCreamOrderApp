package com.example.icecreamorderapp

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*

@Composable
fun IceCreamApp(orderViewModel: OrderViewModel, viewModel: CartViewModel = CartViewModel()) {
    var screen by remember { mutableStateOf("menu") }

    when (screen) {
        "menu" -> IceCreamMenu(viewModel) { screen = "cart" }
        "cart" -> CartScreen(viewModel, orderViewModel) { screen = "menu" }
        "history" -> OrderHistoryScreen(orderViewModel) { screen = "menu" }
    }
}
