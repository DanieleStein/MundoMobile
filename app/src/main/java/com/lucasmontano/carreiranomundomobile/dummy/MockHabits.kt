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

  private val randomHabitList = listOf(
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Walk the dog",
      subtitle = "Não esquecer a coleirinha",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Do the dishes",
      subtitle = "Comprar detergente",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Go to the gym",
      subtitle = "Hoje é seeexta 0/",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Code every day",
      subtitle = "Com as aulas do Lucas Montano",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Make a cup of coffee",
      subtitle = "Em uma xícara ou balde",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Incluído item 7 na lista!",
      subtitle = "Consegui o subtítulo",
      isCompleted = false
    ),
  )

  private val habitItemList: MutableList<HabitItem> = mutableListOf( //Lista mutável de habitos, ela recebe a nossa classe habitItem, com as váriaves que compoem a lista
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Read the book",
      subtitle = "'Como eu era antes de você'",
      isCompleted = false
    )
  )

  //sobscrita dos métodos da HabitsRepository
  override fun fetchHabits() = habitItemList.map { it.copy() }

  override fun addRandomNewHabit() { //função que esta adionando um hábito que esta na nosso mock de hábitos, a nossa lista e forma randomica
    habitItemList.add(randomHabit())
  }

  override fun toggleHabitCompleted(id: String) { //Marcar um hábito como conluído.
    val habitIndex = findHabitIndexById(id)
    val habit = habitItemList[habitIndex]
    habitItemList[habitIndex] = habit.copy(isCompleted = !habit.isCompleted) //pega o state atual, e inverte o valor que esta no momento.
  }

  private fun randomHabit() = randomHabitList.random().copy( //essa função vai pegar randomicamente um hábito que esta acima na nossa lista de hábitos
    id = UUID.randomUUID().toString()
  )

  private fun findHabitIndexById(id: String) = habitItemList.indexOfFirst { habitItem ->
    habitItem.id == id
  }
}
