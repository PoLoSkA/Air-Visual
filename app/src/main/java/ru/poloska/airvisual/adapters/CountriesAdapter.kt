package ru.poloska.airvisual.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.poloska.airvisual.R

/**
 * User: yakimov
 * Date: 2020-02-13
 * Time: 16:52
 */


class CountriesAdapter : AbstractRecyclerAdapter<String, CountriesAdapter.CountriesViewHolder>() {
    override fun layoutId(): Int {
        return R.layout.countries_item
    }

    override fun viewHolder(view: View, type: Int): CountriesViewHolder {
        return CountriesViewHolder(view)
    }

    override fun onBindItemViewHolder(viewHolder: CountriesViewHolder, item: String) {
        viewHolder.bindView(item)
    }

    class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.country_text)

        fun bindView(item: String) {
            title.text = item
        }
    }

}




