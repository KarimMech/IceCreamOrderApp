package com.example.icecreamorderapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrderViewModel(private val repository: OrderRepository) : ViewModel() {
    private val _orders = MutableStateFlow<List<OrderEntity>>(emptyList())
    val orders = _orders.asStateFlow()

    fun loadAllOrders() {
        viewModelScope.launch {
            _orders.value = repository.getAll()
        }
    }

    fun loadSortedByPrice() {
        viewModelScope.launch {
            _orders.value = repository.getSortedByPrice()
        }
    }

    fun loadAbovePrice(min: Double) {
        viewModelScope.launch {
            _orders.value = repository.getAbove(min)
        }
    }

    fun deleteOrder(order: OrderEntity) {
        viewModelScope.launch {
            repository.delete(order)
            loadAllOrders()
        }
    }

    fun addOrder(order: OrderEntity) {
        viewModelScope.launch {
            repository.insert(order)
            loadAllOrders()
        }
    }
}