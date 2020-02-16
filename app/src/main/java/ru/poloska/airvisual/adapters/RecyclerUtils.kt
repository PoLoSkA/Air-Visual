package ru.poloska.airvisual.adapters

import android.graphics.Rect
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Add item offset
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

/**
 * Add recyclerView item click listener
 */
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