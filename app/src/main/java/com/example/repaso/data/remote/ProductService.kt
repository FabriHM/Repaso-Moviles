package com.example.repaso.data.remote

import com.example.repaso.data.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("search")
    fun searchByName(
        @Query("query") query: String,
        @Query("apiKey") apiKey: String = "979b107215934f4786cde0970b5cfe0a"
    ): Call<ProductResponse>
}