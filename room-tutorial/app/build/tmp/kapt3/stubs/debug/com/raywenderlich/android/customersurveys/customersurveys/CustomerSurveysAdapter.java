package com.raywenderlich.android.customersurveys.customersurveys;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/raywenderlich/android/customersurveys/customersurveys/CustomerSurveysAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/raywenderlich/android/customersurveys/customersurveys/CustomerSurveysAdapter$CustomerSurveyViewHolder;", "customerSurveySurveyList", "", "Lcom/raywenderlich/android/customersurveys/customersurveys/SurveyListItem;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CustomerSurveyViewHolder", "app_debug"})
public final class CustomerSurveysAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.raywenderlich.android.customersurveys.customersurveys.CustomerSurveysAdapter.CustomerSurveyViewHolder> {
    private final java.util.List<com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem> customerSurveySurveyList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.raywenderlich.android.customersurveys.customersurveys.CustomerSurveysAdapter.CustomerSurveyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.customersurveys.customersurveys.CustomerSurveysAdapter.CustomerSurveyViewHolder holder, int position) {
    }
    
    public CustomerSurveysAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.raywenderlich.android.customersurveys.customersurveys.SurveyListItem> customerSurveySurveyList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/raywenderlich/android/customersurveys/customersurveys/CustomerSurveysAdapter$CustomerSurveyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "tvUserEmail", "Landroid/widget/TextView;", "getTvUserEmail", "()Landroid/widget/TextView;", "app_debug"})
    public static final class CustomerSurveyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvUserEmail = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvUserEmail() {
            return null;
        }
        
        public CustomerSurveyViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}