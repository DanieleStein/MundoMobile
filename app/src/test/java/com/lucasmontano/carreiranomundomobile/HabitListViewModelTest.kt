package com.lucasmontano.carreiranomundomobile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.lucasmontano.carreiranomundomobile.collections.HabitListViewModel
import org.junit.Before
import org.junit.Rule

//Classe Teste Unitário do ViewModel

class HabitListViewModelTest {
  //No teste queremos que tudo seja executado de forma sincrona
  @get:Rule
  val instantExecutorRule = InstantTaskExecutorRule()

  private val testHabitRepository = TestHabitRepository() //Instancia do testRepository
  private val viewModel = HabitListViewModel(testHabitRepository) //Instancia do ViewModel injetando o testHabitRepository

  @Before //Antes de executar um teste unitario essa função vai ser chamada.
  fun setup() {
    testHabitRepository.habitList.clear() //Limpar os dados do repositorio de teste, porque em cada teste vamos partir do zero
  }


}
