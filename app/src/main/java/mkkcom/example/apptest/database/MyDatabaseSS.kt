package mkkcom.example.apptest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mkkcom.example.apptest.database.dao.ProductDAO
import mkkcom.example.apptest.database.dao.ProductSSDAO
import mkkcom.example.apptest.database.entity.Product
import mkkcom.example.apptest.database.entity.ProductSS

@Database(
    entities = [ProductSS::class],
    version = 1
)
abstract class MyDatabaseSS : RoomDatabase(){

    abstract fun productSSDao(): ProductSSDAO

    companion object{
        @Volatile
        private var INSTANCE : MyDatabaseSS? = null
        fun getDatabase(context: Context) : MyDatabaseSS{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabaseSS::class.java,
                    "my_database "
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}