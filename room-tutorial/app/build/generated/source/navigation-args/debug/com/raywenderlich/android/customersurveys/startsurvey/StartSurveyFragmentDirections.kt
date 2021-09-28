package com.raywenderlich.android.customersurveys.startsurvey

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.raywenderlich.android.customersurveys.R

class StartSurveyFragmentDirections private constructor() {
  companion object {
    fun actionStartSurveyFragmentToSurveyFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_startSurveyFragment_to_surveyFragment)
  }
}
