package com.example.icecreamorderapp

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun CartScreen(viewModel: CartViewModel, orderViewModel: OrderViewModel, onBack: () -> Unit) {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Shopping Cart", style = MaterialTheme.typography.headlineSmall)

        LazyColumn(modifier = Modifier.weight(1f)) {
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

        Button(
            onClick = {
                val order = OrderEntity(
                    items = viewModel.cart.joinToString { it.name },
                    totalPrice = viewModel.getTotal()
                )
                orderViewModel.addOrder(order)
                Toast.makeText(context, "Order saved!", Toast.LENGTH_SHORT).show()
                viewModel.cart.clear()
            },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text("Checkout")
        }

        Button(onClick = onBack, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Back to Menu")
        }
    }
}