package ru.poloska.airvisual.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.poloska.airvisual.R

/**
 * User: yakimov
 * Date: 2020-02-18
 * Time: 18:15
 */
class StatesAdapter: AbstractRecyclerAdapter<String, StatesAdapter.StatesViewHolder>() {
    override fun layoutId(): Int = R.layout.states_item

    override fun viewHolder(view: View, type: Int): StatesViewHolder {
        return StatesViewHolder(view)
    }

    override fun onBindItemViewHolder(viewHolder: StatesViewHolder, item: String) {
        viewHolder.bindView(item)
    }

    class StatesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val state = itemView.findViewById<TextView>(R.id.states_text)

        fun bindView(item: String) {
            state.text = item
        }

    }
}