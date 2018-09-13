package com.ofal.ihsan.sub.view.activities.detail

import com.ofal.ihsan.sub.model.Event
import com.ofal.ihsan.sub.model.Team

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 13, September, 2018
 * ------------------------------
 * This class for view detail
 */
interface DetailView {
    fun hideLoading()
    fun showLoading()
    fun showEventList(data: List<Event>, home: List<Team>, away: List<Team>)
}