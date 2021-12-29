package com.raywenderlich.listmaster

import androidx.room.Room
import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListItemMigrationTest {

    private val TEST_DB_NAME = "migration_test"

    private lateinit var database: SupportSQLiteDatabase

    //1
    @Rule
    @JvmField
    val migrationTestHelperRule = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        "com.raywenderlich.listmaster.AppDatabase",
        FrameworkSQLiteOpenHelperFactory()
    )

    //2
    @Before
    fun setup() {
        database = migrationTestHelperRule.createDatabase(TEST_DB_NAME, 1)
        database.execSQL(
            "INSERT INTO list_categories (id, category_name) VALUES" +
                    " (1, 'Purr Programming Supplies'), (2, 'Canine Coding Supplies')"
        )
    }

    //3
    @After
    fun teardown() {
        database.execSQL("DROP TABLE IF EXISTS list_categories")
        database.execSQL("DROP TABLE IF EXISTS list_items")
        database.close()
    }

    @Test
    fun migrating_from_1_to_2_retains_version_1_data() {
        val listCategories =
            getMigratedRoomDatabase().listCategoryDao().getAll().blockingObserve()
        assertEquals(2, listCategories!!.size)
        assertEquals("Purr Programming Supplies",
            listCategories.first().categoryName)
        assertEquals(1, listCategories.first().id)
        assertEquals("Canine Coding Supplies",
            listCategories.last().categoryName)
        assertEquals(2, listCategories.last().id)
    }

    private fun getMigratedRoomDatabase(): AppDatabase {
        //1
        val appDatabase = Room.databaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            AppDatabase::class.java, TEST_DB_NAME
        )
            //2
            .addMigrations(AppDatabase.MIGRATION_1_TO_2)
            //3
            .build()
        //4
        migrationTestHelperRule.closeWhenFinished(appDatabase)
        return appDatabase
    }
}