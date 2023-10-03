package com.example.repaso.repository

import com.example.repaso.data.local.ProductDao
import com.example.repaso.data.local.ProductEntity
import com.example.repaso.data.model.Product
import com.example.repaso.data.model.ProductResponse
import com.example.repaso.data.remote.ApiClient
import com.example.repaso.data.remote.ProductService
import com.example.repaso.utils.Result
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class ProductRepository (
    private val productDao: ProductDao,
    private val productService: ProductService=ApiClient.getProductService()
){
    fun searchByName(name: String, callback: (Result<List<Product>>)->Unit){
        val searchByName = productService.searchByName(query=name)
        searchByName.enqueue(object : Callback<ProductResponse>{
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>){
                if(response.isSuccessful){
                    try {
                        val products = response.body()!!.products
                        callback(Result.Success(response.body()!!.products))

                    }catch (e: Exception){
                        callback(Result.Success(listOf<Product>()))
                    }
                }
            }
            override fun onFailure(call: Call<ProductResponse>, t: Throwable){
                callback(Result.Error(t.localizedMessage as String))
            }

        })
    }
}