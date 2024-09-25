package mkkcom.example.apptest.di.koin

import android.app.Application
import androidx.room.Room
import mkkcom.example.apptest.api.model.Api
import mkkcom.example.apptest.database.DatabaseConfigs
import mkkcom.example.apptest.database.MyDatabase
import mkkcom.example.apptest.database.dao.CategoryDAO
import mkkcom.example.apptest.database.dao.ProductDAO
import mkkcom.example.apptest.database.entity.Product
import mkkcom.example.apptest.database.migration.Migration1to2
import mkkcom.example.apptest.viewmodel.MyVM
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
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

val appModule = module {

}

val networkModule = module {
    single (named("HeaderInterceptor")){ Api.getHeaderInterceptor() }
    single (named("LoggingInterceptor")){  Api.getLoggingInterceptor() }
    single { Api.createOkHttpClient(get(named("HeaderInterceptor")),get(named("LoggingInterceptor"))) }
    single { Api.createApiService(get()) }

}

val repoModule = module {

}

val vmModule = module {
    viewModel { MyVM(get()) }
}

