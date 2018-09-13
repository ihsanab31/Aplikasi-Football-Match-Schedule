package com.ofal.ihsan.sub.view.activities.detail

import com.google.gson.Gson
import com.ofal.ihsan.sub.api.ApiRequest
import com.ofal.ihsan.sub.api.TheSportApi
import com.ofal.ihsan.sub.model.EventResponse
import com.ofal.ihsan.sub.model.TeamResponse
import com.ofal.ihsan.sub.utils.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 13, September, 2018
 * ------------------------------
 * This class for presenter detail
 */
class DetailPresenter(private val view: DetailView,
                      private val apiRequest: ApiRequest,
                      private val gson: Gson,
                      private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getEventDetail(idEvent: String?, idHomeTeam: String?, idAwayTeam: String?) {
        view.showLoading()

        async(context.main) {
            val eventDetail = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getDetailEvent(idEvent)),
                        EventResponse::class.java)
            }
            val badgeHome = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getHomeBadge(idHomeTeam)),
                        TeamResponse::class.java)
            }
            val badgeAway = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getAwayBadge(idAwayTeam)),
                        TeamResponse::class.java)
            }
            view.showEventList(eventDetail.await().match, badgeHome.await().teams,
                    badgeAway.await().teams)
            view.hideLoading()
        }
    }
}