package ru.poloska.airvisual.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractRecyclerAdapter<T, U : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<U>() {

    private var rcItemsList: ArrayList<T> = ArrayList()

    /**
     * specify item ID
     */
    @LayoutRes
    protected abstract fun layoutId(): Int

    /**
     * create ViewHolder object
     * @param type - view holder types
     */
    protected abstract fun viewHolder(view: View, type: Int): U

    protected abstract fun onBindItemViewHolder(viewHolder: U, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): U {
        return onCreateItemViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: U, position: Int) {
        onBindItemViewHolder(holder, rcItemsList[position])
    }

    override fun getItemCount(): Int {
        return rcItemsList.size
    }

    private fun onCreateItemViewHolder(parent: ViewGroup, viewType: Int): U {
        return viewHolder(
            LayoutInflater.from(parent.context).inflate(layoutId(), parent, false),
            viewType
        )
    }

    fun replaceAllItems(itemsList: List<T>) {
        rcItemsList.clear()
        rcItemsList.addAll(itemsList)
        notifyDataSetChanged()
    }

    fun replaceItem(item: T, position: Int) {
        rcItemsList.add(position, item)
        notifyItemChanged(position)
    }

    fun addAllItems(itemsList: List<T>) {
        rcItemsList.addAll(itemsList)
        notifyItemRangeChanged(rcItemsList.lastIndex, itemsList.lastIndex)
    }

    fun addItemToEnd(item: T) {
        rcItemsList.add(rcItemsList.lastIndex, item)
        notifyItemInserted(rcItemsList.lastIndex)
    }

    fun getItemPosition(item: T): Int {
        return rcItemsList.indexOf(item)
    }

    fun getItem(position: Int): T {
        return rcItemsList[position]
    }
}