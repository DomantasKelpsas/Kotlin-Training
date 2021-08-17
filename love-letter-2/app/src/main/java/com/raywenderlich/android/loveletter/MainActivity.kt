/*
 * Copyright (c) 2019 Razeware LLC
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
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.loveletter

import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.raywenderlich.android.loveletter.databinding.ActivityMainBinding
import com.raywenderlich.android.loveletter.databinding.AppBarMainBinding
import com.raywenderlich.android.loveletter.viewmodel.LettersViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.sentFragment,
                R.id.inboxFragment
            )
        )
    }

    private var lettersViewModel: LettersViewModel? = null
    private var binding: AppBarMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDataBinding()
        setSupportActionBar(toolbar)
        setupNavigation()
        setupViewModel()
        setupViews()
    }

    override fun onDestroy() {
        lettersViewModel?.apply { closeDb() }
        super.onDestroy()
    }

    private fun setupDataBinding() {
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        binding = DataBindingUtil.inflate(
//            layoutInflater, R.layout.app_bar_main, activityMainBinding.linearLayout, false
//        )
/** how to get app bar main binding **/
        
    }

    private fun setupNavigation() {
        NavigationUI.setupActionBarWithNavController(this, navController)

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(
                    R.id.createLetterFragment,
                    R.id.presentationFragment,
                    R.id.editProfileFragment
                )
            ) {
                fab.hide()
            } else {
                fab.show()
            }

            if (destination.id == R.id.presentationFragment) {
                toolbar.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
            }
        }
    }

    private fun setupViewModel() {
        try {
            val viewModelProvider = ViewModelProvider(
                navController.getViewModelStoreOwner(R.id.bottom_nav_graph),
                ViewModelProvider.AndroidViewModelFactory(application)
            )
            lettersViewModel = viewModelProvider.get(LettersViewModel::class.java)
            binding?.viewModel = lettersViewModel /** is this correct? **/
            lettersViewModel?.loadProfile()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }

    private fun setupViews() {
        bottom_nav.setOnNavigationItemSelectedListener(this)

        fab.setOnClickListener {
            navController.navigate(R.id.createLetterFragment)

        }
    }

    override fun onBackPressed() {
        navController.popBackStack(R.id.inboxFragment, false)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_inbox -> {
                navController.popBackStack(R.id.inboxFragment, false)
            }

            R.id.nav_sent -> {
                navController.navigate(R.id.sentFragment)
            }

            R.id.nav_edit_profile -> {
                navController.navigate(R.id.editProfileFragment)
            }

            R.id.nav_privacy_policy -> {
                navController.navigate(Uri.parse("loveletter://agreement/privacy-policy"))
            }

            R.id.nav_terms_of_service -> {
                navController.navigate(Uri.parse("loveletter://agreement/terms-of-service"))
            }
        }
        return true
    }
}
