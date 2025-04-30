package com.example.icecreamorderapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {
    val cart = mutableStateListOf<IceCreamItem>()

    fun addToCart(item: IceCreamItem) {
        cart.add(item)
    }

    fun removeFromCart(item: IceCreamItem) {
        cart.remove(item)
    }

    fun getTotal(): Double {
        return cart.sumOf { it.price }
    }
}