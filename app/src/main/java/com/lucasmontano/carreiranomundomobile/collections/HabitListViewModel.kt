package com.lucasmontano.carreiranomundomobile.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasmontano.carreiranomundomobile.core.HabitsRepository

//Dentro da classe vamos declarar o LiveData que vai ser observado pelo fragment, para conseguir
//identificar modificações da nossa lista de hábitos (sempre que um dado for alterado, excluído,
// adicionado, vai fazer com que o fragment observe as mudanças e avise o nosso adapter que vai
// fazer a comunicação com o RecyclerView para atualizar na tela os dados.

class HabitListViewModel(private val repository: HabitsRepository): ViewModel() { //Nossa classe vai estender de ViewModel do Android e nosso repositorio vai importar o repositorio, pois vai precisar para receber os itens

  private val uiState: MutableLiveData<HabitListUiState> by lazy {
    MutableLiveData<HabitListUiState>(HabitListUiState(habitItemList = repository.fetchHabits()))
  }

  fun stateOnceAndStream(): LiveData<HabitListUiState> = uiState //função para Expor pro fragment observar!Não expomos a nossa unidade principal(val uiState), pois ela é mutable, e não queremos que o fragment altere o nosso state,
                                                                 //mas que só observe o que esta vindo do ViewmModel, e depois pedir para o ViewModel fazer as modificações no state



}
