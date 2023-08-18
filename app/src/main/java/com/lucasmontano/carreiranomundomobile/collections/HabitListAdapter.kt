package com.lucasmontano.carreiranomundomobile.collections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lucasmontano.carreiranomundomobile.R
import com.lucasmontano.carreiranomundomobile.databinding.HabitItemBinding


/**
 * RecyclerView adapter for displaying a list of Habits.
 *
 * The UI is based on the [HabitItemBinding].
 * We use the [HabitItem] as a model for the binding.
 */
class HabitListAdapter(private val habitListViewModel: HabitListViewModel) : RecyclerView.Adapter<HabitListAdapter.ViewHolder>() { //Precisamos que o adapter tenha acesso a ViewModel(private val habitListViewModel: HabitListViewModel)

  private val asyncListDiffer: AsyncListDiffer<HabitItem> = AsyncListDiffer(this, DiffCallback)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { //Vai ser chamado para cada item da nossa lista de hábitos
    val layoutInflater = LayoutInflater.from(parent.context)
    val binding = HabitItemBinding.inflate(layoutInflater, parent, false)
    return ViewHolder(binding, habitListViewModel)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) { //Vai ser chamado para cada item da nossa lista de hábitos
    holder.bind(asyncListDiffer.currentList[position])
  }

  override fun getItemCount(): Int = asyncListDiffer.currentList.size //+ 1 //Simulando um erro, para verificar como corrigir, e como este erro aparece no Logcat

  /**
   * Updates the list of habits.
   *
   * @see [https://medium.com/quark-works/android-asynclistdiffer-recycleviews-best-friend-365f75d84f4]
   */
  fun updateHabits(habits: List<HabitItem>) {
    asyncListDiffer.submitList(habits)
  }

  class ViewHolder(
    private val binding: HabitItemBinding,
    private val viewModel: HabitListViewModel
  ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(habit: HabitItem) {
      binding.titleTextView.text = habit.title
      binding.subtitleTextView.text = habit.subtitle
      binding.completeCheckBox.isChecked = habit.isCompleted
      binding.completeCheckBox.setOnClickListener {  //adicionando um click no checkBox(escutando um click), quando escutar o click, fazer o toggle de marcado para desmarcado, ou de desmarcado para marcado.
        viewModel.toggleHabitCompleted(habit.id)
      }
    }
  }

  object DiffCallback : DiffUtil.ItemCallback<HabitItem>() {
    override fun areItemsTheSame(oldItem: HabitItem, newItem: HabitItem): Boolean {
      return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HabitItem, newItem: HabitItem): Boolean {
      return oldItem == newItem
    }
  }
}
