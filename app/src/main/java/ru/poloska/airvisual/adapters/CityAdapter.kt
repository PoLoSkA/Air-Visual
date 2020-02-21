package ru.poloska.airvisual.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.poloska.airvisual.R

/**
 * User: yakimov
 * Date: 2020-02-19
 * Time: 13:23
 */
class CityAdapter : AbstractRecyclerAdapter<String, CityAdapter.CityViewHolder>() {
    override fun layoutId(): Int = R.layout.city_item

    override fun viewHolder(view: View, type: Int): CityViewHolder {
        return CityViewHolder(view)
    }

    override fun onBindItemViewHolder(viewHolder: CityViewHolder, item: String) {
        viewHolder.bind(item)
    }

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val city = itemView.findViewById<TextView>(R.id.city_text)

        fun bind(item: String) {
            city.text = item
        }

    }
}