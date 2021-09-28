package com.raywenderlich.android.customersurveys.customersurveys;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010R\'\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0011\u0010\nR\'\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0015\u0010\nR\'\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0019\u0010\n\u00a8\u0006\u001e"}, d2 = {"Lcom/raywenderlich/android/customersurveys/customersurveys/CustomerSurveyViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "averageLunchCustomers", "Landroidx/lifecycle/LiveData;", "", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$AverageLunchView;", "getAverageLunchCustomers", "()Landroidx/lifecycle/LiveData;", "averageLunchCustomers$delegate", "Lkotlin/Lazy;", "customerSurveyRepo", "Lcom/raywenderlich/android/customersurveys/customersurveys/CustomerSurveyRepo;", "customerSurveys", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$CustomerSurvey;", "getCustomerSurveys", "customerSurveys$delegate", "sadDinnerCustomers", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$SadDinnerView;", "getSadDinnerCustomers", "sadDinnerCustomers$delegate", "sadQuestionOneCustomers", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem$QuestionOneSadView;", "getSadQuestionOneCustomers", "sadQuestionOneCustomers$delegate", "insertCustomerSurvey", "", "customerSurvey", "app_debug"})
public final class CustomerSurveyViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.raywenderlich.android.customersurveys.customersurveys.CustomerSurveyRepo customerSurveyRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy customerSurveys$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy averageLunchCustomers$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy sadDinnerCustomers$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy sadQuestionOneCustomers$delegate = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.CustomerSurvey>> getCustomerSurveys() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.AverageLunchView>> getAverageLunchCustomers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.SadDinnerView>> getSadDinnerCustomers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.QuestionOneSadView>> getSadQuestionOneCustomers() {
        return null;
    }
    
    public final void insertCustomerSurvey(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem.CustomerSurvey customerSurvey) {
    }
    
    public CustomerSurveyViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}