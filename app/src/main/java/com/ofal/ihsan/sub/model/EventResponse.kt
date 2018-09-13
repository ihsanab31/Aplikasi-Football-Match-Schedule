package com.ofal.ihsan.sub.model

import com.google.gson.annotations.SerializedName

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 13, September, 2018
 * ------------------------------
 * This class for response event
 */
data class EventResponse(
        @SerializedName("events")
        val match: List<Event>
)
