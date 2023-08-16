package com.lucasmontano.carreiranomundomobile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.lucasmontano.carreiranomundomobile.collections.HabitListViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

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

  //Abaixo incluíndo primeiros testes

  @Test
  fun `Verify if uiState is init with data`() {
    //Prepare
    testHabitRepository.addRandomNewHabit() //adidiconar novo hábito no repository

    //Execute
    val uiState = viewModel.stateOnceAndStream().getOrAwaitValue() //Executar o viewModel, e verificar se UiState foi inicializada com algum hábito(Se retornou o UiState)

    //Verify
    assert(uiState.habitItemList.isNotEmpty()) //verificar se UiState retornou com os dados que estão adicionados no nosso repositório
  }

  @Test
  fun `Verify uiState is update when new Habit is completed`() {
    //Observar uiState
    //Marcar um hábito como concluído
    //Pegar o UiState atualizado
    //Verificar se agora ele esta concluído
  }


}
