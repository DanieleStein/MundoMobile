package com.lucasmontano.carreiranomundomobile.core

import com.lucasmontano.carreiranomundomobile.collections.HabitItem

//Centro da nossa aplicação
interface HabitsRepository {

  fun fetchHabits(): List<HabitItem>  //função que vai retornar a lista de habitos

  fun addRandomNewHabit() //adicionar o novo hábito, habitos randomicos, pois ainda não foi criada a interface de cadastro

  fun toggleHabitCompleted(id: String) //função para marcar um hábito específico como concluído, passando o id do hábito

}
