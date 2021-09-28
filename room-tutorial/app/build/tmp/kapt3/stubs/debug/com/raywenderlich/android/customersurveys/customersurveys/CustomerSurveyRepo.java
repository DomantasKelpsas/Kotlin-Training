package com.raywenderlich.android.customersurveys.customersurveys;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\fJ\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\fJ\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\r0\fJ\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/raywenderlich/android/customersurveys/customersurveys/CustomerSurveyRepo;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "customerSurveysDao", "Lcom/raywenderlich/android/customersurveys/customersurveys/CustomerSurveysDao;", "getCustomerSurveysDao", "()Lcom/raywenderlich/android/customersurveys/customersurveys/CustomerSurveysDao;", "customerSurveysDao$delegate", "Lkotlin/Lazy;", "getAllSurveys", "Landroidx/lifecycle/LiveData;", "", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$CustomerSurvey;", "getAverageLunchCustomers", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$AverageLunchView;", "getQuestionOneSadView", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$QuestionOneSadView;", "getSadDinnerCustomers", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$SadDinnerView;", "insertCustomerSurvey", "", "customerSurvey", "(Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$CustomerSurvey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CustomerSurveyRepo {
    private final kotlin.Lazy customerSurveysDao$delegate = null;
    
    private final com.raywenderlich.android.customersurveys.customersurveys.CustomerSurveysDao getCustomerSurveysDao() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertCustomerSurvey(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.CustomerSurvey customerSurvey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.CustomerSurvey>> getAllSurveys() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.SadDinnerView>> getSadDinnerCustomers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.AverageLunchView>> getAverageLunchCustomers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.QuestionOneSadView>> getQuestionOneSadView() {
        return null;
    }
    
    public CustomerSurveyRepo(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}