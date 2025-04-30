package com.example.icecreamorderapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun CartScreen(viewModel: CartViewModel, onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Shopping Cart", style = MaterialTheme.typography.headlineSmall)

        LazyColumn {
            items(viewModel.cart) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("${item.name} - \$${item.price}")
                    Button(onClick = { viewModel.removeFromCart(item) }) {
                        Text("Remove")
                    }
                }
            }
        }

        Text("Total: \$${String.format("%.2f", viewModel.getTotal())}", modifier = Modifier.padding(top = 16.dp))

        Button(onClick = onBack, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Back to Menu")
        }
    }
}