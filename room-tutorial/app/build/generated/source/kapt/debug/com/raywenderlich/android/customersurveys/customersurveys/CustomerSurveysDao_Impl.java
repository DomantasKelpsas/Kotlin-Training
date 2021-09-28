package com.raywenderlich.android.customersurveys.customersurveys;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CustomerSurveysDao_Impl implements CustomerSurveysDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SurveyListItem.CustomerSurvey> __insertionAdapterOfCustomerSurvey;

  public CustomerSurveysDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomerSurvey = new EntityInsertionAdapter<SurveyListItem.CustomerSurvey>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `CustomerSurvey` (`id`,`email`,`meal`,`questionOneValue`,`questionTwoValue`,`questionThreeValue`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SurveyListItem.CustomerSurvey value) {
        stmt.bindLong(1, value.getId());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getMeal() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMeal());
        }
        if (value.getQuestionOneValue() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getQuestionOneValue());
        }
        if (value.getQuestionTwoValue() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getQuestionTwoValue());
        }
        if (value.getQuestionThreeValue() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getQuestionThreeValue());
        }
      }
    };
  }

  @Override
  public Object insertCustomerSurvey(final SurveyListItem.CustomerSurvey customerReview,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCustomerSurvey.insert(customerReview);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<SurveyListItem.CustomerSurvey>> getAllSurveys() {
    final String _sql = "SELECT * FROM CustomerSurvey";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"CustomerSurvey"}, false, new Callable<List<SurveyListItem.CustomerSurvey>>() {
      @Override
      public List<SurveyListItem.CustomerSurvey> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "meal");
          final int _cursorIndexOfQuestionOneValue = CursorUtil.getColumnIndexOrThrow(_cursor, "questionOneValue");
          final int _cursorIndexOfQuestionTwoValue = CursorUtil.getColumnIndexOrThrow(_cursor, "questionTwoValue");
          final int _cursorIndexOfQuestionThreeValue = CursorUtil.getColumnIndexOrThrow(_cursor, "questionThreeValue");
          final List<SurveyListItem.CustomerSurvey> _result = new ArrayList<SurveyListItem.CustomerSurvey>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SurveyListItem.CustomerSurvey _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpMeal;
            _tmpMeal = _cursor.getString(_cursorIndexOfMeal);
            final String _tmpQuestionOneValue;
            _tmpQuestionOneValue = _cursor.getString(_cursorIndexOfQuestionOneValue);
            final String _tmpQuestionTwoValue;
            _tmpQuestionTwoValue = _cursor.getString(_cursorIndexOfQuestionTwoValue);
            final String _tmpQuestionThreeValue;
            _tmpQuestionThreeValue = _cursor.getString(_cursorIndexOfQuestionThreeValue);
            _item = new SurveyListItem.CustomerSurvey(_tmpId,_tmpEmail,_tmpMeal,_tmpQuestionOneValue,_tmpQuestionTwoValue,_tmpQuestionThreeValue);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<SurveyListItem.SadDinnerView>> getSadDinnerCustomers() {
    final String _sql = "SELECT * FROM SadDinnerView";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"SadDinnerView"}, false, new Callable<List<SurveyListItem.SadDinnerView>>() {
      @Override
      public List<SurveyListItem.SadDinnerView> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final List<SurveyListItem.SadDinnerView> _result = new ArrayList<SurveyListItem.SadDinnerView>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SurveyListItem.SadDinnerView _item;
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _item = new SurveyListItem.SadDinnerView(_tmpEmail);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<SurveyListItem.AverageLunchView>> getAverageLunchCustomers() {
    final String _sql = "SELECT * FROM AverageLunchView";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"AverageLunchView"}, false, new Callable<List<SurveyListItem.AverageLunchView>>() {
      @Override
      public List<SurveyListItem.AverageLunchView> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final List<SurveyListItem.AverageLunchView> _result = new ArrayList<SurveyListItem.AverageLunchView>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SurveyListItem.AverageLunchView _item;
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _item = new SurveyListItem.AverageLunchView(_tmpEmail);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<SurveyListItem.QuestionOneSadView>> getQuestionOneSadView() {
    final String _sql = "SELECT * FROM QuestionOneSadView";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"QuestionOneSadView"}, false, new Callable<List<SurveyListItem.QuestionOneSadView>>() {
      @Override
      public List<SurveyListItem.QuestionOneSadView> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final List<SurveyListItem.QuestionOneSadView> _result = new ArrayList<SurveyListItem.QuestionOneSadView>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SurveyListItem.QuestionOneSadView _item;
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _item = new SurveyListItem.QuestionOneSadView(_tmpEmail);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
