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
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.android.databinding.FragmentAnimalBinding
import com.raywenderlich.android.zooguide.defineHanger
import com.raywenderlich.android.zooguide.interfaces.Flyable
import com.raywenderlich.android.zooguide.interfaces.Swimmable
import com.raywenderlich.android.zooguide.interfaces.Walkable
import com.raywenderlich.android.zooguide.loadImage
import com.raywenderlich.android.zooguide.model.AnimalStore
import com.raywenderlich.android.zooguide.model.animals.*
import com.raywenderlich.android.zooguide.ui.adapter.ColorsAdapter
import com.raywenderlich.android.zooguide.ui.viewmodels.AnimalViewModel
import java.lang.Exception

class AnimalFragment : Fragment() {

    private lateinit var binding: FragmentAnimalBinding
    private val viewModel: AnimalViewModel by viewModels()
    private lateinit var adapter: ColorsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAnimalBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val name = AnimalFragmentArgs.fromBundle(it).name
            viewModel.updateAnimal(AnimalStore.getAnimal(name))
        }

        viewModel.animal.observe(viewLifecycleOwner, { animal ->

            animal.run {
                binding.fullName.text = name
                binding.animalImage.loadImage(image)
                binding.foodImage.loadImage(food.resId)
                binding.habitatImage.loadImage(habitat.resId)

                // TODO: Implement the behaviours with the interfaces
                var speed = ""
                speed = when (this) {
                    is Swimmable -> speed.plus(this.swimmingSpeed.toString() + "km/h\n")
                    is Flyable -> speed.plus(this.flyingSpeed.toString() + "km/h\n")
                    is Walkable -> speed.plus(this.walkingSpeed.toString() + "km/h\n")
                    else -> throw Exception("Unknown animal")
                }
                binding.speedVelocity.text = speed
                // TODO: Choose the correct image using the interfaces
//        binding.movementImage.loadImage()

                binding.hangerText.text = animal.getHungerAmount().defineHanger()

                setUpColorList(animal)
            }
        })
    }

    private fun setUpColorList(animal: Animal) {

        val list = when (animal) {
            is Mammal -> animal.furColor
            is Bird -> animal.feathersColor
            else -> emptyList()
        }

        adapter = ColorsAdapter(list)

        binding.colorList.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = this@AnimalFragment.adapter
        }
    }
}