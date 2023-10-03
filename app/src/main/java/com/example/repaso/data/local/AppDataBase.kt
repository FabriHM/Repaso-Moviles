package com.example.repaso.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.repaso.data.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    companion object{
        fun getInstance(context: Context): AppDataBase{
            val db = Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "products-db"
            ).allowMainThreadQueries()
                .build()
            return db
        }
    }
}