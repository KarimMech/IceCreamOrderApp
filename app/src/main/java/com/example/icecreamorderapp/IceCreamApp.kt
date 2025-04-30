package com.example.icecreamorderapp

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*

@Composable
fun IceCreamApp(viewModel: CartViewModel = CartViewModel()) {
    var showCart by remember { mutableStateOf(false) }

    if (showCart) {
        CartScreen(viewModel, onBack = { showCart = false })
    } else {
        IceCreamMenu(viewModel, onCartClick = { showCart = true })
    }
}