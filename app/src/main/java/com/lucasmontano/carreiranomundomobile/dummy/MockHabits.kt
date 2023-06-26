package com.lucasmontano.carreiranomundomobile.dummy

import com.lucasmontano.carreiranomundomobile.collections.HabitItem
import java.util.*

/**
 * Mock data with [HabitItem] for the collection.
 */
object MockHabits { //Nosso objeto com os dados mocados para teste

  val habitItemList: MutableList<HabitItem> = mutableListOf(  //Lista mutável de habitos, ela recebe a nossa classe habitList
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Read the book",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Walk the dog",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Do the dishes",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Go to the gym",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Code every day",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Make a cup of coffee",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      title = "Incluído item 7 na lista!",
      isCompleted = false
    ),
  )
}
