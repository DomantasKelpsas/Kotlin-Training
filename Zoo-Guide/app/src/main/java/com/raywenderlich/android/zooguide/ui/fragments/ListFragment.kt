/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.zooguide.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.android.databinding.FragmentListBinding
import com.raywenderlich.android.zooguide.model.AnimalStore
import com.raywenderlich.android.zooguide.ui.adapter.AnimalsAdapter
import com.raywenderlich.android.zooguide.ui.viewmodels.ListViewModel

class ListFragment : Fragment() {

  private lateinit var binding: FragmentListBinding
  private lateinit var animalsAdapter: AnimalsAdapter
  private val viewModel: ListViewModel by viewModels()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View {
    // Inflate the layout for this fragment
    binding = FragmentListBinding.inflate(layoutInflater)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setUpAdapter()

    binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onNothingSelected(p0: AdapterView<*>?) { /* Do nothing */ }

      override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // TODO: Implement behaviour
      }
    }

    viewModel.items.observe(viewLifecycleOwner, { items ->
      if (this::animalsAdapter.isInitialized) {
        animalsAdapter.submitList(items)
      }
    })
  }

  private fun setUpAdapter() {
    animalsAdapter = AnimalsAdapter { animal ->
      //onClick
      findNavController().navigate(ListFragmentDirections.actionListFragmentToAnimalFragment(animal.name))
    }

    binding.allList.apply {
      layoutManager = LinearLayoutManager(requireContext())
      adapter = animalsAdapter
      addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
    }
  }
}