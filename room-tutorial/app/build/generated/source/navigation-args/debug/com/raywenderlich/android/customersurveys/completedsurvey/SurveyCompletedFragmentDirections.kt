package com.raywenderlich.android.customersurveys.completedsurvey

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.raywenderlich.android.customersurveys.R

class SurveyCompletedFragmentDirections private constructor() {
  companion object {
    fun actionSurveyCompletedFragmentToAllSurveysFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_surveyCompletedFragment_to_allSurveysFragment)
  }
}
