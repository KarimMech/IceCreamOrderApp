package com.example.icecreamorderapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun OrderHistoryScreen(
    viewModel: OrderViewModel,
    onBack: () -> Unit
) {
    var filterMode by remember { mutableStateOf("All") }

    LaunchedEffect(filterMode) {
        when (filterMode) {
            "All" -> viewModel.loadAllOrders()
            "Sorted" -> viewModel.loadSortedByPrice()
            "Above10" -> viewModel.loadAbovePrice(10.0)
        }
    }

    val orders by viewModel.orders.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Order History", style = MaterialTheme.typography.headlineSmall)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { filterMode = "All" }) { Text("All") }
            Button(onClick = { filterMode = "Sorted" }) { Text("Sort by Price") }
            Button(onClick = { filterMode = "Above10" }) { Text("Price > $10") }
        }

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(orders) { order ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Items: ${order.items}")
                        Text("Total: \$${order.totalPrice}")
                        Button(
                            onClick = { viewModel.deleteOrder(order) },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text("Delete")
                        }
                    }
                }
            }
        }

        Button(onClick = onBack, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Back")
        }
    }
}