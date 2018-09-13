package com.ofal.ihsan.sub.utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 13, September, 2018
 * ------------------------------
 * This class for Space item
 */
class SpaceItemDecoration (private val spacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?,
                                state: RecyclerView.State?) {
        if(outRect != null && parent != null) {
            var position = parent.getChildAdapterPosition(view)
            outRect.left = spacing
            outRect.right = spacing
            outRect.bottom = spacing

            if(position < 1) outRect.top = spacing
        }
    }
}