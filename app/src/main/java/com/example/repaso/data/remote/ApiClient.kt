package com.example.repaso.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.spoonacular.com/food/products/"
    private var productService: ProductService?=null

    fun getProductService(): ProductService {
           val retrofit = Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
              productService = retrofit.create(ProductService::class.java)
        return productService as ProductService
    }
}