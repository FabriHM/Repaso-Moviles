package com.example.repaso.ui.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repaso.data.local.AppDataBase
import com.example.repaso.data.model.Product
import com.example.repaso.repository.ProductRepository
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ProductList(products: MutableState<List<Product>>) {
    //val context = LocalContext.current
    //val productDao = AppDataBase.getInstance(context).productDao()
    //val productRepository = ProductRepository(productDao)

    LazyColumn {
        items(products.value) { product ->
            ProductRow(product)
        }
    }
}

@Composable
fun ProductRow(
    product: Product,
){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Row (verticalAlignment = Alignment.CenterVertically){
            ProductImage(product.image)
            Column {
                Text(text = product.id.toString())
                Text(text = product.title)
            }
        }

    }
}

@Composable
fun ProductImage(url: String){
    GlideImage(
        imageModel = {url},
        imageOptions = ImageOptions(contentScale = ContentScale.Fit),
        modifier = Modifier
            .size(92.dp)
    )
}