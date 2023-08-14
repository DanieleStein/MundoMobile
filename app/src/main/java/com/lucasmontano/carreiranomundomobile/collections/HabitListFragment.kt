package com.lucasmontano.carreiranomundomobile.collections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.lucasmontano.carreiranomundomobile.R
import com.lucasmontano.carreiranomundomobile.databinding.FragmentHabitListBinding
import com.lucasmontano.carreiranomundomobile.dummy.MockHabits

/**
 * A [Fragment] that displays a list of habits.
 */
class HabitListFragment : Fragment() {

  private var _binding: FragmentHabitListBinding? = null

  private val binding get() = _binding!!

  private lateinit var adapter: HabitListAdapter //o adapter é uma variavel que vamos inicializar depois(laiteinit)

  private val viewModel: HabitListViewModel by activityViewModels { //activityViewModels seja criada e essa instancia é criada e armazenada no escopo da activity, então se qualquer fragmemt dentro da ctivity pedir viewModel do tipo HabitListViewModel o mesmo viewModel vai ser fornecido
    HabitListViewModel.Factory(MockHabits)                                      //Porque a activity precisa ter acesso a essa mesma instancia do ViewModel
  }

  override fun onCreate(savedInstanceState: Bundle?) { //Vai ser chamado automaticamente pelo android quando o fragment for criado
    super.onCreate(savedInstanceState) //Nesse momento a View do Layout onde está o RecyclerView, ainda não foi inflada com os dados
    adapter = HabitListAdapter(viewModel) //Caso usuario fechar o app, o fragment vai ser distruido, e caso ele retome o app, o fragment é recriado
  }

  override fun onCreateView( //Vai criar a View do nosso fragment
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentHabitListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    // Set the adapter
    binding.habitRecyclerView.layoutManager = LinearLayoutManager(requireContext()) //O layoutManager vai controlar como vamos exibir os itens na tela no recyclerView. E o LinearLayoutManager organiza os itens na tela(lista)
    binding.habitRecyclerView.adapter = adapter //Conectar o adapter no RecyclerView

    // Adding decorations to our recycler view
    addingDividerDecoration() //Adicionando o tipo de layout que quero de espaçamento entre os itens da lista

    // Updating the list of habits (Fornecendo nossa lista de hábitos para o adapter em uma função chamada updateHabits
    //adapter.updateHabits(MockHabits.habitItemList)  - Desabilitando pois nosso fragment não vai mais observar direto do MockHabits, e sim do ViewModel
    viewModel                      //Então agora vamos pedir para o viewModel
      .stateOnceAndStream()        //observar o nosso state
      .observe(viewLifecycleOwner) { state ->   //chamando o metodo observe, e informando até quando ele deve observar (viewLifecycleOwner)enquanto a view existir
        bindUiState(state)
      }
  }

  private fun bindUiState(state: HabitListUiState) { //função vai receber o state
    adapter.updateHabits(state.habitItemList)        //vai fazer a atualização no adapter com a lista que esta vindo do state
  }

  private fun addingDividerDecoration() { //Função para implementar as linhas divisórias de tarefas do app
    // Adding Line between items with MaterialDividerItemDecoration
    val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL) //Instancia do MaterialDividerItemDecoration, passando o contexto(requireContext()) e organização da lista(LinearLayoutManager.VERTICAL)

    // Removing the line at the end of the list
    divider.isLastItemDecorated = false //Remove a ultíma linha

    val resources = requireContext().resources

    // Adding start spacing
    divider.dividerInsetStart = resources.getDimensionPixelSize(R.dimen.horizontal_margin) //Onde inicia essa linha divisória, tem uma margem de 16dp

    // Defining size of the line
    divider.dividerThickness = resources.getDimensionPixelSize(R.dimen.divider_height) //Grossura da linha
    divider.dividerColor = ContextCompat.getColor(requireContext(), R.color.primary_200) //Cor da linha

    binding.habitRecyclerView.addItemDecoration(divider) //adidiconando o divider no Recycler View
  }

  private fun addingDividerSpace() { //metodo para caso só quiser deixar um espaçamento entre os ContraintLayouts, sem a linha(esse metodo pode ser usado quando queremos colocar uma imagem embaixo da outra, e ter um espaçamento)
    binding.habitRecyclerView.addItemDecoration(HabitListItemDecoration(requireContext()))
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
