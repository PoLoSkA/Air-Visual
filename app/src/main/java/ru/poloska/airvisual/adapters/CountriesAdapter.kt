package ru.poloska.airvisual.adapters

import android.content.Context
import android.graphics.Rect
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.poloska.airvisual.R
import ru.poloska.airvisual.data.models.app_model.CountriesList

/**
 * User: yakimov
 * Date: 2020-02-13
 * Time: 16:52
 */

inline fun RecyclerView.setOnItemClickListener(crossinline itemListener: (position: Int) -> Unit) {
    addOnItemTouchListener(
        RecyclerItemClickListener(this,
            object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    itemListener(position)
                }
            })
    )
}

class CountriesAdapter(context: Context) : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    private var inflater = LayoutInflater.from(context)
    private var countriesList = ArrayList<String>()

    override fun getItemCount(): Int {
        return countriesList.size
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        return holder.bind(countriesList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(inflater.inflate(R.layout.countries_item, parent, false))
    }

    fun replaceItems(countriesList: List<String>){
        this.countriesList.clear()
        this.countriesList.addAll(countriesList)

        notifyDataSetChanged()
    }

    fun getItem(position: Int): String{
        return countriesList[position]
    }

    class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryText = itemView.findViewById<TextView>(R.id.country_text)

        fun bind(item: String) {
            countryText.text = item
        }
    }
}

open class RecyclerItemClickListener(recyclerView: RecyclerView, private val mListener: OnItemClickListener?) :
    RecyclerView.OnItemTouchListener {
    private var mGestureDetector: GestureDetector =
        GestureDetector(recyclerView.context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }

            override fun onLongPress(e: MotionEvent) {}
        })

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    override fun onInterceptTouchEvent(view: RecyclerView, e: MotionEvent): Boolean {
        val childView = view.findChildViewUnder(e.x, e.y)
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView))
            return true
        }
        return false
    }

    override fun onTouchEvent(view: RecyclerView, motionEvent: MotionEvent) {}
    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
}

/**
 * @param top - set item offsets from top
 * @param bottom - set item offsets from bottom
 * @param left - set item offsets from left
 * @param right - set item offsets from right
 */
class RecyclerItemDecorator(
    private val top: Int,
    private val bottom: Int,
    private val left: Int,
    private val right: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val position = parent.getChildLayoutPosition(view)

        if (position != RecyclerView.NO_POSITION) {
            outRect.set(left, top, right, bottom)
        } else {
            outRect.set(0, 0, 0, 0)
        }
    }
}