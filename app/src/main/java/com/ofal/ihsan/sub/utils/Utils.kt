package com.ofal.ihsan.sub.utils

import android.content.Context
import android.view.View
import com.ofal.ihsan.sub.model.db.FavoriteDBHelper

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 13, September, 2018
 * ------------------------------
 * This class for visibility
 */

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

val Context.db: FavoriteDBHelper
    get() = FavoriteDBHelper.getInstance(applicationContext)
