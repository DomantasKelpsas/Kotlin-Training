package com.raywenderlich.listmaster.listcategory

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ListCategoryDao {

    @Query("SELECT * FROM list_categories")
    fun getAll(): LiveData<List<ListCategory>>

    @Insert
    fun insertAll(vararg listCategories: ListCategory)
}