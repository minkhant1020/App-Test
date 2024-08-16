package mkkcom.example.apptest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mkkcom.example.apptest.database.entity.Product
import mkkcom.example.apptest.database.entity.ProductSS

@Dao
interface ProductSSDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(productSS: ProductSS)

    @Insert
    fun insertAll(vararg productSS: ProductSS)

    @Insert
    fun insertAll( productSS: List<ProductSS>)

    @Query("SELECT * FROM productSS")
    fun getAllProduct(): LiveData<List<ProductSS>>

    @Delete
    fun deleteProduct(productSS: ProductSS)


}