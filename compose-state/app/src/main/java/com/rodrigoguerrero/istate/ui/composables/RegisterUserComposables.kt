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
package com.rodrigoguerrero.istate.ui.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.istate.R
import com.rodrigoguerrero.istate.models.RegistrationFormData
import com.rodrigoguerrero.istate.models.User
import com.rodrigoguerrero.istate.models.avengersList

@Composable
fun RegistrationFormScreen(
  registrationFormData: RegistrationFormData,
  onEmailChanged: (String) -> Unit,
  onUsernameChanged: (String) -> Unit,
  onStarWarsSelectedChanged: (Boolean) -> Unit,
  onFavoriteAvengerChanged: (String) -> Unit,
  onRegisterClicked: (User) -> Unit,
  onClearClicked: () -> Unit
) {
  Column(
    modifier = Modifier.padding(16.dp)
  ) {
    EditTextField(leadingIcon = Icons.Default.Email,
      placeholder = R.string.email,
      value = registrationFormData.email,
      isError = !registrationFormData.isValidEmail,
      onValueChanged = { onEmailChanged(it) }
    )

    EditTextField(
      leadingIcon = Icons.Default.AccountBox,
      placeholder = R.string.username,
      modifier = Modifier.padding(top = 16.dp),
      value = registrationFormData.username,
      isError = false,
      onValueChanged = { onUsernameChanged(it) }
    )

    Row(
      Modifier
        .fillMaxWidth()
        .padding(top = 16.dp)
    ) {
      RadioButtonWithText(
        text = R.string.star_wars,
        isSelected = registrationFormData.isStarWarsSelected,
        onClick = { onStarWarsSelectedChanged(true) }
      )

      RadioButtonWithText(
        text = R.string.star_trek,
        isSelected = !registrationFormData.isStarWarsSelected,
        onClick = { onStarWarsSelectedChanged(false) }
      )
    }

    DropDown(
      menuItems = avengersList,
      onItemSelected = { onFavoriteAvengerChanged(it) },
      selectedItem = registrationFormData.favoriteAvenger
    )

    OutlinedButton(
      onClick = {
        onRegisterClicked(
          User(
            username = registrationFormData.username,
            email = registrationFormData.email,
            favoriteAvenger = registrationFormData.favoriteAvenger,
            likesStarWars = registrationFormData.isStarWarsSelected
          )
        )
      },
      modifier = Modifier.fillMaxWidth(),
      enabled = registrationFormData.isRegisterEnabled
    ) {
      Text(stringResource(R.string.register))
    }
    OutlinedButton(
      onClick = { onClearClicked() },
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp)
    ) {
      Text(stringResource(R.string.clear))
    }
  }
}

@Composable
fun EditTextField(
  leadingIcon: ImageVector,
  @StringRes placeholder: Int,
  modifier: Modifier = Modifier,
  value: String,
  isError: Boolean,
  onValueChanged: (String) -> Unit,
) {
  //var text by remember { mutableStateOf("") }

  OutlinedTextField(
    value = value,
    isError = isError,
    onValueChange = { onValueChanged(it) },
    leadingIcon = { Icon(leadingIcon, contentDescription = "") },
    modifier = modifier.fillMaxWidth(),
    placeholder = { Text(stringResource(placeholder)) }
  )
}

@Composable
fun RadioButtonWithText(
  isSelected: Boolean,
  onClick: () -> Unit,
  @StringRes text: Int,
  modifier: Modifier = Modifier
) {
  //var isSelected by remember { mutableStateOf(false) }

  RadioButton(
    selected = isSelected,
    onClick = { onClick() }
  )
  Text(
    text = stringResource(text),
    style = MaterialTheme.typography.body1.merge(),
    modifier = modifier.padding(start = 8.dp, end = 8.dp)
  )
}

@Composable
fun DropDown(
  selectedItem: String,
  onItemSelected: (String) -> Unit,
  menuItems: List<String>,
  modifier: Modifier = Modifier
) {
  //var selectedItem by remember { mutableStateOf("Select your favorite Avenger:") }
// 2.
  var isExpanded by remember { mutableStateOf(false) }

  Row(
    modifier = Modifier
      .padding(vertical = 16.dp)
      .clickable { isExpanded = true }
  ) {
    Text(selectedItem)
    Icon(Icons.Filled.ArrowDropDown, contentDescription = "")
    DropdownMenu(
      expanded = isExpanded,
      onDismissRequest = { isExpanded = false },
      modifier = modifier
        .fillMaxWidth()
        .background(Color.White)
    ) {
      menuItems.forEachIndexed { index, name ->
        DropdownMenuItem(onClick = {
          onItemSelected(menuItems[index])
          isExpanded = false
        }) {
          Text(text = name)
        }
      }
    }
  }
}
