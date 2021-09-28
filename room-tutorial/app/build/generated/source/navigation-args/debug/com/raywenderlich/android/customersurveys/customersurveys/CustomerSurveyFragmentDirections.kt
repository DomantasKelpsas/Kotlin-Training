package com.raywenderlich.android.customersurveys.customersurveys

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.raywenderlich.android.customersurveys.R

class CustomerSurveyFragmentDirections private constructor() {
  companion object {
    fun actionSurveyFragmentToSurveyCompletedFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_surveyFragment_to_surveyCompletedFragment)
  }
}
