package com.example.icecreamorderapp

import androidx.room.*

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: OrderEntity)

    @Query("SELECT * FROM orders")
    suspend fun getAllOrders(): List<OrderEntity>

    @Query("SELECT * FROM orders ORDER BY totalPrice ASC")
    suspend fun getOrdersSortedByPrice(): List<OrderEntity>

    @Query("SELECT * FROM orders WHERE totalPrice > :minPrice")
    suspend fun getOrdersAbovePrice(minPrice: Double): List<OrderEntity>

    @Delete
    suspend fun deleteOrder(order: OrderEntity)
}