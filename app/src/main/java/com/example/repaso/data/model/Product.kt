package com.example.repaso.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("products")
    val products: List<Product>
)

data class Product(
    val id: Int,
    val title: String,
    val image: String)

