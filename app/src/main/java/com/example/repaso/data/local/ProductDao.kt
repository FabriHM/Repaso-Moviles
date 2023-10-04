package com.example.repaso.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    fun saveProducts(product: ProductEntity)

    @Delete
    fun deleteProducts(product: ProductEntity)

    @Query("select * from products")
    fun getProducts(): List<ProductEntity>

    @Query("select * from products WHERE id = :id")
    fun getProductById(id: Int): ProductEntity

}