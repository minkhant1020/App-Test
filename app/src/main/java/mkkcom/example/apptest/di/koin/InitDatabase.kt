package mkkcom.example.apptest.di.koin

import android.app.Application
import androidx.room.Room
import mkkcom.example.apptest.database.DatabaseConfigs
import mkkcom.example.apptest.database.MyDatabase
import mkkcom.example.apptest.database.dao.CategoryDAO
import mkkcom.example.apptest.database.dao.ProductDAO
import mkkcom.example.apptest.database.entity.Product
import mkkcom.example.apptest.database.migration.Migration1to2
import org.koin.dsl.module

fun initDatabase(application: Application ) :MyDatabase =
     Room.databaseBuilder(
        application,
        MyDatabase::class.java,
        DatabaseConfigs.DATABASE_NAME
    )
        .addMigrations(Migration1to2())
        .allowMainThreadQueries()
        .build()

fun categoryDAO(myDatabase: MyDatabase): CategoryDAO = myDatabase.categoryDAO()

val dataBaseModule= module {
    single { initDatabase(get()) }
    single { categoryDAO(get()) }
}

