package com.example.icecreamorderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = OrderDatabase.getDatabase(applicationContext)
        val repository = OrderRepository(db.orderDao())

        setContent {
            val orderViewModel: OrderViewModel = viewModel(factory = object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return OrderViewModel(repository) as T
                }
            })

            MaterialTheme {
                Surface {
                    IceCreamNavApp(orderViewModel)
                }
            }
        }
    }
}