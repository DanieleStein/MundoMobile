package com.lucasmontano.carreiranomundomobile

import com.lucasmontano.carreiranomundomobile.collections.HabitItem
import com.lucasmontano.carreiranomundomobile.core.HabitsRepository
import java.util.UUID

//Classe Repositório de testes, sobrescrevendo as 3 funções que o ViewModel vai chamar, pois os testes unitários vão ser do ViewModel

class TestHabitRepository: HabitsRepository{

  val habitList = mutableListOf<HabitItem>()

  override fun fetchHabits() = habitList //retorna a lista de hábitos

  override fun addHabit(name: String, habitDaySelected: List<Int>) {
    //TODO implementar o uso do [habitDaySelected]
    habitList.add(
      HabitItem(
        id = UUID.randomUUID().toString(),
        title = name,
        isCompleted = false)
    )
  }

  override fun toggleHabitCompleted(id: String) { //Marcar hábito como concluído
    val index = habitList.indexOfFirst { it.id == id } //Buscar o index do hábito que tem aquele id
    habitList[index] = habitList[index].copy(isCompleted = !habitList[index].isCompleted) //Acessar a posição(index), fazendo uma cópia do valor atual, mas mudando o is completed para !(diferente) do atual
  }
}
