package com.raywenderlich.android.customersurveys.customersurveys;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003H\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u0003H\'J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/raywenderlich/android/customersurveys/customersurveys/CustomerSurveysDao;", "", "getAllSurveys", "Landroidx/lifecycle/LiveData;", "", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$CustomerSurvey;", "getAverageLunchCustomers", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$AverageLunchView;", "getQuestionOneSadView", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$QuestionOneSadView;", "getSadDinnerCustomers", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$SadDinnerView;", "insertCustomerSurvey", "", "customerReview", "(Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$CustomerSurvey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CustomerSurveysDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertCustomerSurvey(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.CustomerSurvey customerReview, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM CustomerSurvey")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.CustomerSurvey>> getAllSurveys();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM SadDinnerView")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.SadDinnerView>> getSadDinnerCustomers();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM AverageLunchView")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.AverageLunchView>> getAverageLunchCustomers();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM QuestionOneSadView")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.QuestionOneSadView>> getQuestionOneSadView();
}