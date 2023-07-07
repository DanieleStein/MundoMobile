package com.lucasmontano.carreiranomundomobile.collections

import android.graphics.drawable.Icon
import android.media.Image
import android.widget.ImageView
import android.widget.Switch

/**
 * Habit Model representing an Item in a ListView.
 *
 * @param title the title of the habit
 * @param isCompleted whether the habit is checked or not
 */
data class HabitItem(
  val id: String,
  val switch: Boolean,
  val title: String,
  val subtitle: String,
  val isCompleted: Boolean
)
