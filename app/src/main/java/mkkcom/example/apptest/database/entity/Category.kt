package mkkcom.example.apptest.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import mkkcom.example.apptest.database.DatabaseConfigs

@Entity(tableName = DatabaseConfigs.TABLE_CATEGORY)
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,
)
