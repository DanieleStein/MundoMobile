package com.lucasmontano.carreiranomundomobile.collections

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lucasmontano.carreiranomundomobile.R

/**
 * Item Decoration to add space between items in the recycler view.
 */
class HabitListItemDecoration(context: Context) : RecyclerView.ItemDecoration() { //Criada uma classe de HabitListItemDecoration que extend de RecyclerView.ItemDecoration()

  private val space = context.resources.getDimensionPixelSize(R.dimen.simple_margin)

  override fun getItemOffsets( //sobrescrita de metodo configurando todos os espaçamento para 8dp
    outRect: Rect, view: View, parent: RecyclerView,
    state: RecyclerView.State
  ) {
    outRect.left = space
    outRect.right = space
    outRect.bottom = space
    outRect.top = space
  }
}
