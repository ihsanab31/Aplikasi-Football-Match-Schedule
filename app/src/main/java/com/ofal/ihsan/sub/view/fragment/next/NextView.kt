package com.ofal.ihsan.sub.view.fragment.next

import com.ofal.ihsan.sub.model.Event

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 13, September, 2018
 * ------------------------------
 * This class for view next
 */
interface NextView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>?)
    fun errorMessage(message: String?)
}