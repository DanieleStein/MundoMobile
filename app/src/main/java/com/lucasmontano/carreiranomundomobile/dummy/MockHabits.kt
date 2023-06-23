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
      posicao = "1",
      title = "Read the book",
      subtitle = "'Como eu era antes de você'",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      posicao = "2",
      title = "Walk the dog",
      subtitle = "Lembrar da coleirinha",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      posicao = "3",
      title = "Do the dishes",
      subtitle = "Lembrar de comprar detergente",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      posicao = "4",
      title = "Go to the gym",
      subtitle = "Hoje é seeeexta o/",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      posicao = "5",
      title = "Code every day",
      subtitle = "Aprendendo com Lucas Montano",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      posicao = "6",
      title = "Make a cup of coffee",
      subtitle = "Na minha xícara/balde",
      isCompleted = false
    ),
  )
}
