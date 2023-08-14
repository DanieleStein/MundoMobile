package com.lucasmontano.carreiranomundomobile.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucasmontano.carreiranomundomobile.core.HabitsRepository

//Dentro da classe vamos declarar o LiveData que vai ser observado pelo fragment, para conseguir
//identificar modificações da nossa lista de hábitos (sempre que um dado for alterado, excluído,
//adicionado, vai fazer com que o fragment observe as mudanças e avise o nosso adapter que vai
//fazer a comunicação com o RecyclerView para atualizar na tela os dados.

class HabitListViewModel(private val repository: HabitsRepository): ViewModel() { //Nossa classe vai estender de ViewModel do Android e nosso repositorio vai importar o repositorio, pois vai precisar para receber os itens

  private val uiState: MutableLiveData<HabitListUiState> by lazy {
    MutableLiveData<HabitListUiState>(HabitListUiState(habitItemList = repository.fetchHabits()))
  }

  fun stateOnceAndStream(): LiveData<HabitListUiState> = uiState //função para Expor pro fragment observar!Não expomos a nossa unidade principal(val uiState), pois ela é mutable, e não queremos que o fragment altere o nosso state,
                                                                 //mas que só observe o que esta vindo do ViewmModel, e depois pedir para o ViewModel fazer as modificações no state

  fun addRandomHabit() { //funcao vai ser chamada pela nossa activity, onde esta o botao para adicionar um hábito
    repository.addRandomNewHabit() //chamando a função que esta no repository
    refreshUiState() //atualizar o UiState, state
  }

  fun toggleHabitCompleted(habitId: String) { //Função para amrcar um hábito como concluído
    repository.toggleHabitCompleted(habitId)  //chamar repository, marcar um hábito como concluído, passar o id desse hábito
    refreshUiState()                          //depois dar o refreshUi State da tela
  }

  private fun refreshUiState() { //função para atualizar a lista de dados
    uiState.value?.let { currentUiState ->   //Pegar o valor atual do (uiState)
      uiState.value = currentUiState.copy(   //Então modifica o uiState com uma cópia do atual,
        habitItemList = repository.fetchHabits()  //porém buscando do repositório uma lista atualizada
      )
    }
  }

  //Criar um factory do nosso ViewModel, vai ser utilizado pelo fragment para poder criar uma instancia desse ViewModel
  class Factory(private val repository: HabitsRepository): ViewModelProvider.Factory {    //Classe vai receber o repository no construtor, e vai extender de ViewModelProvider.Factory

    override fun <T : ViewModel> create(modelClass: Class<T>): T { //Vai criar o ViewModel com repositorio
      return HabitListViewModel(repository) as T
    }
  }



}
