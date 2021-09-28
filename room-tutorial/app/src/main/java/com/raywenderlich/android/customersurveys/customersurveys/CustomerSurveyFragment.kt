/*
 *
 *  * Copyright (c) 2020 Razeware LLC
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  * furnished to do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in
 *  * all copies or substantial portions of the Software.
 *  *
 *  * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 *  * distribute, sublicense, create a derivative work, and/or sell copies of the
 *  * Software in any work that is designed, intended, or marketed for pedagogical or
 *  * instructional purposes related to programming, coding, application development,
 *  * or information technology.  Permission for such use, copying, modification,
 *  * merger, publication, distribution, sublicensing, creation of derivative works,
 *  * or sale is expressly withheld.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  * THE SOFTWARE.
 *
 */

package com.raywenderlich.android.customersurveys.customersurveys

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.raywenderlich.android.customersurveys.R
import kotlinx.android.synthetic.main.fragment_customer_survey.*

class CustomerSurveyFragment : Fragment() {
  private var questionOneAnswer: String? = null
  private var questionTwoAnswer: String? = null
  private var questionThreeAnswer: String? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_customer_survey, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    btnSubmitSurvey.setOnClickListener {
      submitSurvey()
    }
    toggleButtonListeners()

  }

  private fun toggleButtonListeners() {
    layoutQuestionOne.addOnButtonCheckedListener { group, checkedId, isChecked ->
      questionOneAnswer = when (checkedId) {
        R.id.imgHappyReaction -> "Good"
        R.id.imgBasicHappyReaction -> "Average"
        R.id.imgSadReaction -> "Sad"
        else -> "No Answer"
      }
    }

    layoutQuestionTwo.addOnButtonCheckedListener { group, checkedId, isChecked ->
      questionTwoAnswer = when (checkedId) {
        R.id.imgHappyReaction2 -> "Good"
        R.id.imgBasicHappyReaction2 -> "Average"
        R.id.imgSadReaction2 -> "Sad"
        else -> "No Answer"
      }
    }

    layoutQuestionThree.addOnButtonCheckedListener { group, checkedId, isChecked ->
      questionThreeAnswer = when (checkedId) {
        R.id.imgHappyReaction3 -> "Good"
        R.id.imgBasicHappyReaction3 -> "Average"
        R.id.imgSadReaction3 -> "Sad"
        else -> "No Answer"
      }
    }
  }

  private fun submitSurvey() {
    Toast.makeText(requireContext(), getString(R.string.text_not_time_for_survey), Toast.LENGTH_SHORT).show()
  }

  private fun validateEmail(email: String): Boolean {
    var valid = false
    when {
      TextUtils.isEmpty(email) -> {
        inputLayoutEmail.error = "Email required"
        editEmail.requestFocus()
        valid = false
      }
      else -> {
        inputLayoutEmail.error = null
        valid = true
      }
    }
    when {
      !TextUtils.isEmpty(email) -> {
        when {
          android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
            inputLayoutEmail.error = null
            valid = true
          }
          else -> {
            inputLayoutEmail.error = "Invalid email address"
            editEmail.requestFocus()
            valid = false
          }
        }
      }
    }
    return valid
  }
}