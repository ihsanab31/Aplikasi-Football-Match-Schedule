package com.ofal.ihsan.sub.view.fragment.prev

import com.ofal.ihsan.sub.model.Event

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 13, September, 2018
 * ------------------------------
 * This class for prev view
 */
interface PrevView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}