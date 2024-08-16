package mkkcom.example.apptest.database

import mkkcom.example.apptest.database.dao.ProductSSDAO
import mkkcom.example.apptest.database.entity.ProductSS

class ProductsRepository(private val productSSDAO: ProductSSDAO) {
    val allProducts = productSSDAO.getAllProduct()
    suspend fun insert(productSS: ProductSS){
        productSSDAO.insert(productSS)
    }
   /* suspend fun delete(productSS: ProductSS){
        productSSDAO.delete(productSS)*/
    }
