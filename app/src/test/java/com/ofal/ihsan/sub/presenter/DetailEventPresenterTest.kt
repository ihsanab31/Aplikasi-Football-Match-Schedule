package com.ofal.ihsan.sub.presenter

import com.google.gson.Gson
import com.ofal.ihsan.sub.TestContextProvider
import com.ofal.ihsan.sub.api.ApiRequest
import com.ofal.ihsan.sub.api.TheSportApi
import com.ofal.ihsan.sub.model.Event
import com.ofal.ihsan.sub.model.EventResponse
import com.ofal.ihsan.sub.model.Team
import com.ofal.ihsan.sub.model.TeamResponse
import com.ofal.ihsan.sub.view.activities.detail.DetailPresenter
import com.ofal.ihsan.sub.view.activities.detail.DetailView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 17, September, 2018
 * ------------------------------
 * This class for detail testing
 */
class DetailEventPresenterTest {
    @Mock
    private lateinit var view: DetailView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: DetailPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun testGetNextEvent() {
        val events: MutableList<Event> = mutableListOf()
        val home: MutableList<Team> = mutableListOf()
        val away: MutableList<Team> = mutableListOf()
        val response = EventResponse(events)
        val homeResponse = TeamResponse(home)
        val awayResponse = TeamResponse(away)
        val idEvent = "526916"
        val idHomeTeam = "134778"
        val idAwayTeam = "133613"

        `when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getDetailEvent(idEvent)),
                EventResponse::class.java)).thenReturn(response)
        `when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getHomeBadge(idHomeTeam)),
                TeamResponse::class.java)).thenReturn(homeResponse)
        `when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getAwayBadge(idAwayTeam)),
                TeamResponse::class.java)).thenReturn(awayResponse)

        presenter.getEventDetail(idEvent, idHomeTeam, idAwayTeam)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEventList(events, home, away)
        Mockito.verify(view).hideLoading()
    }
}