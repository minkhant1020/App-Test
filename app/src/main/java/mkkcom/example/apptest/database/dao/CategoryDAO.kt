package mkkcom.example.apptest.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import mkkcom.example.apptest.database.entity.Category
import mkkcom.example.apptest.database.entity.Product

@Dao
interface CategoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category)

}