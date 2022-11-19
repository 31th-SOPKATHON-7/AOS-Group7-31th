package org.sopt.sopkathon_31th.ui.home.part.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PartMemberDecorator() : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        if (position % 2 == 0) {
            outRect.left = 60
            outRect.right = 12
        } else {
            outRect.left = 12
            outRect.right = 60
        }

        if (position < 2) {
            outRect.top = 48
            outRect.bottom = 24
        } else {
            outRect.top = 24
            outRect.bottom = 24
        }
    }
}
