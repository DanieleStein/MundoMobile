package com.lucasmontano.carreiranomundomobile.dummy

import android.graphics.drawable.Icon
import android.media.Image
import android.text.style.BackgroundColorSpan
import android.widget.ImageView
import com.lucasmontano.carreiranomundomobile.R
import com.lucasmontano.carreiranomundomobile.collections.HabitItem
import com.lucasmontano.carreiranomundomobile.core.HabitsRepository
import java.util.*

/**
 * Mock data with [HabitItem] for the collection.
 */
object MockHabits : HabitsRepository{      //Nosso objeto com os dados mocados para teste, vai estender de HabitRepository(e assim puxar as funções que estão na interface estendida)

  private val habitItemList: MutableList<HabitItem> = mutableListOf() //Lista mutável de habitos, ela recebe a nossa classe habitItem, com as váriaves que compoem a lista

  //sobscrita dos métodos da HabitsRepository
  override fun fetchHabits() = habitItemList.map { it.copy() }

  override fun addHabit(name: String, habitDaysSelected: List<Int>) {
    //TODO implementar o uso do [habitDaySelected]
    habitItemList.add(
      HabitItem(
        id = UUID.randomUUID().toString(),
        title = name,
        isCompleted = false
      )
    )
  }

  override fun toggleHabitCompleted(id: String) { //Marcar um hábito como conluído.
    val habitIndex = findHabitIndexById(id)
    val habit = habitItemList[habitIndex]
    habitItemList[habitIndex] = habit.copy(isCompleted = !habit.isCompleted) //pega o state atual, e inverte o valor que esta no momento.
  }

  private fun findHabitIndexById(id: String) = habitItemList.indexOfFirst { habitItem ->
    habitItem.id == id
  }
}
