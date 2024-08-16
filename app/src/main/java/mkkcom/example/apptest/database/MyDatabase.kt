package mkkcom.example.apptest.database


import androidx.room.Database
import androidx.room.RoomDatabase
import mkkcom.example.apptest.database.dao.CategoryDAO
import mkkcom.example.apptest.database.dao.ProductDAO
import mkkcom.example.apptest.database.entity.Category
import mkkcom.example.apptest.database.entity.Product

@Database(
    entities = [Product::class, Category::class],
    version = DatabaseConfigs.DATABASE_VERSION,
    exportSchema = true

)
abstract class MyDatabase : RoomDatabase(){

    abstract fun productDao(): ProductDAO
    abstract fun categoryDAO(): CategoryDAO
}