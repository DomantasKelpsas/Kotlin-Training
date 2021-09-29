/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.listmaster

import android.content.Context
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.raywenderlich.listmaster.listcategory.ListCategory
import com.raywenderlich.listmaster.listcategory.ListCategoryDao
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ListCategoryDaoTest {

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var listCategoryDao: ListCategoryDao

    @Before
    fun setup() {
        val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
        try {
            database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                .allowMainThreadQueries().build()
        } catch (e: Exception) {
            Log.i("test", e.message)
        }
        listCategoryDao = database.listCategoryDao()

    }

    @Test
    fun testAddingAndRetrievingData() {
        val preInsertRetrievedCategories = listCategoryDao.getAll()

        val listCategory = ListCategory("Cats", 1)
        listCategoryDao.insertAll(listCategory)

        val postInsertRetrievedCategories = listCategoryDao.getAll()
        val sizeDifference = postInsertRetrievedCategories.size - preInsertRetrievedCategories.size
        Assert.assertEquals(1, sizeDifference)
        val retrievedCategory = postInsertRetrievedCategories.last()
        Assert.assertEquals("Cats", retrievedCategory.categoryName)
    }

    @After
    fun tearDown() {
        database.close()
    }
}