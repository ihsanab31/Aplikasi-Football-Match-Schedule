package com.ofal.ihsan.sub.api

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 17, September, 2018
 * ------------------------------
 * This class for api
 */
class ApiRepositoryTest {
    @Test
    fun testPreEventApi() {
        val apiRepository = mock(ApiRequest::class.java)
        val url = TheSportApi.getPrevEvent("4328")
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }

    @Test
    fun testNextEventApi() {
        val apiRequest = mock(ApiRequest::class.java)
        val url = TheSportApi.getNextEvent("4328")
        apiRequest.doRequest(url)
        verify(apiRequest).doRequest(url)
    }
}