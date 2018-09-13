package com.ofal.ihsan.sub.api

import java.net.URL

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 13, September, 2018
 * ------------------------------
 * This class for url api
 */
class ApiRequest  {

    fun doRequest(url: String) : String {
        return URL(url).readText()
    }

}