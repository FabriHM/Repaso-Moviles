package com.example.repaso.ui.products

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.repaso.data.local.AppDataBase
import com.example.repaso.data.model.Product
import com.example.repaso.repository.ProductRepository
import com.example.repaso.utils.Result

@Composable
fun Search() {

    val textQuery = remember {
        mutableStateOf("")
    }

    val products = remember {
        mutableStateOf(listOf<Product>())
    }
    //val context = LocalContext.current

    Column {
        ProductSearch(textQuery, products)
        ProductList(products)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductSearch(
    textQuery: MutableState<String>,
    products: MutableState<List<Product>>
) {
    val context = LocalContext.current
    //val productDao = AppDataBase.getInstance(context).productDao()
    //val repository = ProductRepository(productDao)
    
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        value = textQuery.value,
        placeholder = { Text("Search product") },
        onValueChange = { newtextQuery ->
            textQuery.value = newtextQuery
        },
        leadingIcon = {
            Icon(Icons.Filled.Search, null)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                repository.searchByName(textQuery.value) { result ->
                    if(result is Result.Success){
                        products.value = result.data!!
                    }else{
                        Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )
    )
}
