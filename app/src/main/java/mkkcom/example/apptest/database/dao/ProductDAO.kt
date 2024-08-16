package mkkcom.example.apptest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import mkkcom.example.apptest.database.entity.Product
import mkkcom.example.apptest.database.entity.ProductSS

@Dao
interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product)

    @Insert
    fun insertAll(vararg product: Product)

    @Insert
    fun insertAll( product: List<Product>)

    @Query("SELECT * FROM product")
    fun getAllProduct(): List<Product>

    @Delete
    fun delete(product: Product)

    @Update
    fun update(product: Product)

    @Query("SELECT * FROM product WHERE price <= :price ORDER BY name")
    fun getProductsByMaxPrice(price: Double): List<Product>


}
