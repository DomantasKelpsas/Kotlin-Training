package com.raywenderlich.android.customersurveys.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.room.util.ViewInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.raywenderlich.android.customersurveys.customersurveys.CustomerSurveysDao;
import com.raywenderlich.android.customersurveys.customersurveys.CustomerSurveysDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile CustomerSurveysDao _customerSurveysDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CustomerSurvey` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `email` TEXT NOT NULL, `meal` TEXT NOT NULL, `questionOneValue` TEXT, `questionTwoValue` TEXT, `questionThreeValue` TEXT)");
        _db.execSQL("CREATE VIEW `AverageLunchView` AS SELECT CustomerSurvey.email FROM CustomerSurvey WHERE CustomerSurvey.meal = 'Lunch'");
        _db.execSQL("CREATE VIEW `SadDinnerView` AS SELECT CustomerSurvey.email FROM CustomerSurvey WHERE CustomerSurvey.meal = 'Dinner'");
        _db.execSQL("CREATE VIEW `QuestionOneSadView` AS SELECT  CustomerSurvey.email FROM CustomerSurvey WHERE CustomerSurvey.questionOneValue = 'Sad'");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '72737943c8444bfa0c674528b05e61a0')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `CustomerSurvey`");
        _db.execSQL("DROP VIEW IF EXISTS `AverageLunchView`");
        _db.execSQL("DROP VIEW IF EXISTS `SadDinnerView`");
        _db.execSQL("DROP VIEW IF EXISTS `QuestionOneSadView`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCustomerSurvey = new HashMap<String, TableInfo.Column>(6);
        _columnsCustomerSurvey.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerSurvey.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerSurvey.put("meal", new TableInfo.Column("meal", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerSurvey.put("questionOneValue", new TableInfo.Column("questionOneValue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerSurvey.put("questionTwoValue", new TableInfo.Column("questionTwoValue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomerSurvey.put("questionThreeValue", new TableInfo.Column("questionThreeValue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomerSurvey = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomerSurvey = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomerSurvey = new TableInfo("CustomerSurvey", _columnsCustomerSurvey, _foreignKeysCustomerSurvey, _indicesCustomerSurvey);
        final TableInfo _existingCustomerSurvey = TableInfo.read(_db, "CustomerSurvey");
        if (! _infoCustomerSurvey.equals(_existingCustomerSurvey)) {
          return new RoomOpenHelper.ValidationResult(false, "CustomerSurvey(com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.CustomerSurvey).\n"
                  + " Expected:\n" + _infoCustomerSurvey + "\n"
                  + " Found:\n" + _existingCustomerSurvey);
        }
        final ViewInfo _infoAverageLunchView = new ViewInfo("AverageLunchView", "CREATE VIEW `AverageLunchView` AS SELECT CustomerSurvey.email FROM CustomerSurvey WHERE CustomerSurvey.meal = 'Lunch'");
        final ViewInfo _existingAverageLunchView = ViewInfo.read(_db, "AverageLunchView");
        if (! _infoAverageLunchView.equals(_existingAverageLunchView)) {
          return new RoomOpenHelper.ValidationResult(false, "AverageLunchView(com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.AverageLunchView).\n"
                  + " Expected:\n" + _infoAverageLunchView + "\n"
                  + " Found:\n" + _existingAverageLunchView);
        }
        final ViewInfo _infoSadDinnerView = new ViewInfo("SadDinnerView", "CREATE VIEW `SadDinnerView` AS SELECT CustomerSurvey.email FROM CustomerSurvey WHERE CustomerSurvey.meal = 'Dinner'");
        final ViewInfo _existingSadDinnerView = ViewInfo.read(_db, "SadDinnerView");
        if (! _infoSadDinnerView.equals(_existingSadDinnerView)) {
          return new RoomOpenHelper.ValidationResult(false, "SadDinnerView(com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.SadDinnerView).\n"
                  + " Expected:\n" + _infoSadDinnerView + "\n"
                  + " Found:\n" + _existingSadDinnerView);
        }
        final ViewInfo _infoQuestionOneSadView = new ViewInfo("QuestionOneSadView", "CREATE VIEW `QuestionOneSadView` AS SELECT  CustomerSurvey.email FROM CustomerSurvey WHERE CustomerSurvey.questionOneValue = 'Sad'");
        final ViewInfo _existingQuestionOneSadView = ViewInfo.read(_db, "QuestionOneSadView");
        if (! _infoQuestionOneSadView.equals(_existingQuestionOneSadView)) {
          return new RoomOpenHelper.ValidationResult(false, "QuestionOneSadView(com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.QuestionOneSadView).\n"
                  + " Expected:\n" + _infoQuestionOneSadView + "\n"
                  + " Found:\n" + _existingQuestionOneSadView);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "72737943c8444bfa0c674528b05e61a0", "c7cd53d31c4fac763756408da87100bb");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(3);
    HashSet<String> _tables = new HashSet<String>(1);
    _tables.add("CustomerSurvey");
    _viewTables.put("averagelunchview", _tables);
    HashSet<String> _tables_1 = new HashSet<String>(1);
    _tables_1.add("CustomerSurvey");
    _viewTables.put("saddinnerview", _tables_1);
    HashSet<String> _tables_2 = new HashSet<String>(1);
    _tables_2.add("CustomerSurvey");
    _viewTables.put("questiononesadview", _tables_2);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "CustomerSurvey");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `CustomerSurvey`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public CustomerSurveysDao customerSurveysDao() {
    if (_customerSurveysDao != null) {
      return _customerSurveysDao;
    } else {
      synchronized(this) {
        if(_customerSurveysDao == null) {
          _customerSurveysDao = new CustomerSurveysDao_Impl(this);
        }
        return _customerSurveysDao;
      }
    }
  }
}
