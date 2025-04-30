package com.example.icecreamorderapp
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun IceCreamOrderScreen() {
    var type by remember { mutableStateOf("Cone") }
    var quantity by remember { mutableStateOf(0) }
    val context = LocalContext.current
    val price = if (type == "Cup") 3.39 else 3.69
    val total = quantity * price

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Choose Type")
        Row {
            Button(onClick = { type = "Cup" }) { Text("Cup") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { type = "Cone" }) { Text("Cone") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Quantity")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { if (quantity > 0) quantity-- }) { Text("-") }
            OutlinedTextField(
                value = quantity.toString(),
                onValueChange = {
                    val q = it.toIntOrNull()
                    if (q == null || q < 0) {
                        Toast.makeText(context, "Quantity can't be negative", Toast.LENGTH_SHORT).show()
                    } else quantity = q
                },
                modifier = Modifier.width(80.dp)
            )
            Button(onClick = { quantity++ }) { Text("+") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Total: \$${String.format("%.2f", total)}")
    }
}