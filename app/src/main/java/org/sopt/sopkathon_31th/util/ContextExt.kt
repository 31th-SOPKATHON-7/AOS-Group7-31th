package org.sopt.sopkathon_31th.util

import android.content.Context
import android.widget.Toast

object ContextExt {
    fun Context.shortToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
