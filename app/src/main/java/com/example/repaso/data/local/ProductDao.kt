package com.example.repaso.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface ProductDao {
    @Insert
    fun saveProducts(product: ProductEntity)

    @Delete
    fun deleteProducts(product: ProductEntity)

    @Query("SELECT * FROM products")
    fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    fun getProductById(id: Int): ProductEntity

}