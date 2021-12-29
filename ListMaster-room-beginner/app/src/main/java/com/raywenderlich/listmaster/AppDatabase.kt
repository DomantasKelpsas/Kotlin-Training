package com.raywenderlich.listmaster

import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.RoomDatabase
import com.raywenderlich.listmaster.listcategory.ListCategory
import com.raywenderlich.listmaster.listcategory.ListCategoryDao
import com.raywenderlich.listmaster.listitem.ListItem
import com.raywenderlich.listmaster.listitem.ListItemDao
import com.raywenderlich.listmaster.migrations.Migration1To2

@Database(entities = [ListCategory::class, ListItem::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun listCategoryDao(): ListCategoryDao

    abstract fun listItemDao(): ListItemDao

    companion object {

        @VisibleForTesting
        val MIGRATION_1_TO_2 = Migration1To2()
    }
}