package org.sopt.sopkathon_31th.data.local

import android.content.Context

object NameThiefStorage {
    private const val STORAGE_KEY = "COIN"
    private const val COIN_COUNT = "COIN_COUNT"

    fun getCoinCount(context: Context): Int {
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        return preferences.getInt(COIN_COUNT, 0)
    }

    fun setCoinCout(context: Context, plusCount: Int) {
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        preferences.edit()
            .putInt(COIN_COUNT, preferences.getInt(COIN_COUNT, 0) + plusCount)
            .apply()
    }
}
