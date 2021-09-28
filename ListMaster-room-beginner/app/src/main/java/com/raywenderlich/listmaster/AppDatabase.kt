package com.raywenderlich.listmaster

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raywenderlich.listmaster.listcategory.ListCategory
import com.raywenderlich.listmaster.listcategory.ListCategoryDao

@Database(entities = [(ListCategory::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun listCategoryDao(): ListCategoryDao
}