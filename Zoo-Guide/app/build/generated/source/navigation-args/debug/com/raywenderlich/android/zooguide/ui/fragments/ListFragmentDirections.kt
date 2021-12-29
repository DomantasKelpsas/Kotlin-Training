package com.raywenderlich.android.zooguide.ui.fragments

import android.os.Bundle
import androidx.navigation.NavDirections
import com.raywenderlich.android.R
import kotlin.Int
import kotlin.String

public class ListFragmentDirections private constructor() {
  private data class ActionListFragmentToAnimalFragment(
    public val name: String
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_listFragment_to_animalFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("name", this.name)
      return result
    }
  }

  public companion object {
    public fun actionListFragmentToAnimalFragment(name: String): NavDirections =
        ActionListFragmentToAnimalFragment(name)
  }
}
