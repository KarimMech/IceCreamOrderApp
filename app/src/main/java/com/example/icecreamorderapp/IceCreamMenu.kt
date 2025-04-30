package com.example.icecreamorderapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IceCreamMenu(viewModel: CartViewModel, onCartClick: () -> Unit) {
    val items = listOf(
        IceCreamItem("Vanilla Cone", "Vanilla", 3.69),
        IceCreamItem("Chocolate Cup", "Chocolate", 3.39),
        IceCreamItem("Strawberry Cone", "Strawberry", 3.69),
        IceCreamItem("Mint Cup", "Mint", 3.39),
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Ice Cream Menu", style = MaterialTheme.typography.headlineSmall)
        LazyColumn {
            items(items) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { viewModel.addToCart(item) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("${item.name} - \$${item.price}")
                        Text("Flavor: ${item.flavor}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
        Button(
            onClick = onCartClick,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Go to Cart")
        }
    }
}