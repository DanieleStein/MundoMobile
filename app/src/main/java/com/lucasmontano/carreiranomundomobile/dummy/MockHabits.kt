package com.lucasmontano.carreiranomundomobile.dummy

import android.media.Image
import android.widget.ImageView
import com.lucasmontano.carreiranomundomobile.R
import com.lucasmontano.carreiranomundomobile.collections.HabitItem
import java.util.*

/**
 * Mock data with [HabitItem] for the collection.
 */
object MockHabits { //Nosso objeto com os dados mocados para teste

  val habitItemList: MutableList<HabitItem> = mutableListOf(  //Lista mutável de habitos, ela recebe a nossa classe habitList
    HabitItem(
      id = UUID.randomUUID().toString(),
      image = R.drawable.checked,
      title = "Read the book",
      subtitle = "'Como eu era antes de você'",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      image = R.drawable.checked,
      title = "Walk the dog",
      subtitle = "Não esquecer a coleirinha",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      image = R.drawable.checked,
      title = "Do the dishes",
      subtitle = "Comprar detergente",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      image = R.drawable.checked,
      title = "Go to the gym",
      subtitle = "Hoje é seeexta 0/",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      image = R.drawable.checked,
      title = "Code every day",
      subtitle = "Com as aulas do Lucas Montana",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      image = R.drawable.checked,
      title = "Make a cup of coffee",
      subtitle = "Em uma xícara ou balde",
      isCompleted = false
    ),
    HabitItem(
      id = UUID.randomUUID().toString(),
      image = R.drawable.checked,
      title = "Incluído item 7 na lista!",
      subtitle = "Consegui o subtítulo",
      isCompleted = false
    ),
  )
}
