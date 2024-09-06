package mkkcom.example.apptest.helper

import android.app.Application
import androidx.compose.ui.unit.Dp
import androidx.room.Room
import androidx.room.migration.Migration
import dagger.hilt.android.HiltAndroidApp
import mkkcom.example.apptest.database.DatabaseConfigs
import mkkcom.example.apptest.database.MyDatabase
import mkkcom.example.apptest.database.migration.Migration1to2
import mkkcom.example.apptest.di.koin.dataBaseModule
import mkkcom.example.apptest.di.koin.initDatabase
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

//@HiltAndroidApp
class MyApp : Application() {

//lateinit var initDatabase: MyDatabase

    override fun onCreate() {
        super.onCreate()
       startKoin {
           androidContext(this@MyApp)
           modules(dataBaseModule)
       }
    }



}