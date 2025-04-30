package com.example.icecreamorderapp

class OrderRepository(private val dao: OrderDao) {
    suspend fun insert(order: OrderEntity) = dao.insertOrder(order)
    suspend fun getAll() = dao.getAllOrders()
    suspend fun getSortedByPrice() = dao.getOrdersSortedByPrice()
    suspend fun getAbove(minPrice: Double) = dao.getOrdersAbovePrice(minPrice)
    suspend fun delete(order: OrderEntity) = dao.deleteOrder(order)
}