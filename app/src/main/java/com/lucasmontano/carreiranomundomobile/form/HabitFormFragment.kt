package com.lucasmontano.carreiranomundomobile.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.lucasmontano.carreiranomundomobile.collections.HabitListViewModel
import com.lucasmontano.carreiranomundomobile.databinding.FragmentHabitFormBinding
import com.lucasmontano.carreiranomundomobile.dummy.MockHabits

class HabitFormFragment : Fragment() {

  private var _binding: FragmentHabitFormBinding? = null

  private val binding get() = _binding!!

  private val viewModel: HabitListViewModel by activityViewModels {
    HabitListViewModel.Factory(MockHabits)
  }

  override fun onCreateView( //Cria a View, infla o layoutInflater
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentHabitFormBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) { //Evento que o Fragment vai chamar quando a View for criada
    super.onViewCreated(view, savedInstanceState)
    //Save Habit and Navigate Up
    binding.saveButton.setOnClickListener { onSave() } //Acessa o botão de salvar, adiciona escuta no clic(setOnClickListener) e chama o metodo onSave.
  }

  private fun onSave() {
    //Pegar o valor adiconado no input para ser salvo
    val habitName = binding.titleTextInput.editText?.text.toString()

    //Pegar os periodos(dias) selecionados. Onde 1 é Monday e 7 é Sunday.
    val habitDaysSelected = binding.daysChipGroup.checkedChipIds //checkedChipIds(retorna uma lista de inteiros)

    //Chamar o ViewModel para adicionar um novo hábito
    viewModel.addHabit(habitName, habitDaysSelected)

    //Navegar o usuario para trás, da tela onde veio
    findNavController().navigateUp()
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

}
