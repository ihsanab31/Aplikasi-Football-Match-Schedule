package com.ofal.ihsan.sub.model

import com.google.gson.annotations.SerializedName

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 13, September, 2018
 * ------------------------------
 * This class for model team
 */
data class Team(
        @SerializedName("idTeam") var teamId: String? = null,
        @SerializedName("strTeam") var teamName: String? = null,
        @SerializedName("strTeamBadge") var teamBadge: String? = null
)