package com.ofal.ihsan.sub.view.fragment.prev

import com.google.gson.Gson
import com.ofal.ihsan.sub.api.ApiRequest
import com.ofal.ihsan.sub.api.TheSportApi
import com.ofal.ihsan.sub.model.EventResponse
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
 * This class for presenter prev
 */
class PrevPresenter(private val view: PrevView,
                    private val apiRequest: ApiRequest,
                    private val gson: Gson,
                    private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getEventList(match: String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getSchedule(match)),
                        EventResponse::class.java
                )
            }
            view.showEventList(data.await().match)
            view.hideLoading()
        }
    }
}