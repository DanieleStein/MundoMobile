package com.lucasmontano.carreiranomundomobile.core

import com.lucasmontano.carreiranomundomobile.collections.HabitItem

//Centro da nossa aplicação
interface HabitsRepository {

  fun fetchHabits(): List<HabitItem>  //função que vai retornar a lista de habitos

  fun toggleHabitCompleted(id: String) //função para marcar um hábito específico como concluído, passando o id do hábito

  fun addHabit(name: String, habitDaySelected: List<Int>)

}
