package mkkcom.example.apptest.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mkkcom.example.apptest.database.entity.ProductSS

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    val allProductSS : LiveData<List<ProductSS>>
    private val repository : ProductsRepository

    init {
        val dao = MyDatabaseSS.getDatabase(application).productSSDao()
        repository = ProductsRepository(dao)
        allProductSS = repository.allProducts
    }
    fun insertProduct(productSS: ProductSS) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(productSS)
    }

   /* fun deleteProduct(productSS: ProductSS) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(productSS)*/

    }
