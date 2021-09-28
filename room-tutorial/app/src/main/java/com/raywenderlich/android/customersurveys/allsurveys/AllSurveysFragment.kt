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

package com.raywenderlich.android.customersurveys.allsurveys

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.raywenderlich.android.customersurveys.R
import com.raywenderlich.android.customersurveys.customersurveys.CustomerSurveyViewModel
import com.raywenderlich.android.customersurveys.customersurveys.CustomerSurveysAdapter
import kotlinx.android.synthetic.main.fragment_all_surveys.*

class AllSurveysFragment : Fragment(R.layout.fragment_all_surveys) {
  private val customerSurveyViewModel: CustomerSurveyViewModel by viewModels()
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupSpinner()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
      Navigation.findNavController(requireActivity(), R.id.navHostFragment).navigateUp()
    }
    callback.isEnabled
  }

  private fun resetState() {
    layoutEmptyView.visibility = View.VISIBLE
    rvReviews.visibility = View.GONE
  }

  private fun getAllCustomerSurveys() {
    customerSurveyViewModel.customerSurveys.observe(viewLifecycleOwner, Observer { customerSurveys ->
      if (customerSurveys.isEmpty()) {
        layoutEmptyView.visibility = View.VISIBLE
        rvReviews.visibility = View.GONE
      } else {
        layoutEmptyView.visibility = View.GONE
        rvReviews.visibility = View.VISIBLE
        val customerSurveysAdapter = CustomerSurveysAdapter(customerSurveys)
        rvReviews.adapter = customerSurveysAdapter
      }

    })
  }

  private fun getQuestionOneSadCustomers() {
    customerSurveyViewModel.sadQuestionOneCustomers.observe(viewLifecycleOwner, Observer { sadQuestionOneCustomers ->
      if (sadQuestionOneCustomers.isEmpty()) {
        layoutEmptyView.visibility = View.VISIBLE
        rvReviews.visibility = View.GONE
      } else {
        layoutEmptyView.visibility = View.GONE
        rvReviews.visibility = View.VISIBLE
        val questionOneSadAdapter = CustomerSurveysAdapter(sadQuestionOneCustomers)
        rvReviews.adapter = questionOneSadAdapter
      }

    })
  }

  private fun getAverageLunchCustomers() {
    customerSurveyViewModel.averageLunchCustomers.observe(viewLifecycleOwner, Observer { averageLunchCustomers ->
      if (averageLunchCustomers.isEmpty()) {
        layoutEmptyView.visibility = View.VISIBLE
        rvReviews.visibility = View.GONE
      } else {
        layoutEmptyView.visibility = View.GONE
        rvReviews.visibility = View.VISIBLE
        val averageLunchAdapter = CustomerSurveysAdapter(averageLunchCustomers)
        rvReviews.adapter = averageLunchAdapter
      }

    })
  }

  private fun getSadDinnerCustomers() {
    customerSurveyViewModel.sadDinnerCustomers.observe(viewLifecycleOwner, Observer { sadDinnerCustomers ->
      if (sadDinnerCustomers.isEmpty()) {
        layoutEmptyView.visibility = View.VISIBLE
        rvReviews.visibility = View.GONE
      } else {
        layoutEmptyView.visibility = View.GONE
        rvReviews.visibility = View.VISIBLE
        val sadDinnerAdapter = CustomerSurveysAdapter(sadDinnerCustomers)
        rvReviews.adapter = sadDinnerAdapter
      }

    })
  }

  private fun setupSpinner() {
    val arrayAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.array_filter_categories, android.R.layout.simple_spinner_item)
    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    filterSpinner.adapter = arrayAdapter
  }
}