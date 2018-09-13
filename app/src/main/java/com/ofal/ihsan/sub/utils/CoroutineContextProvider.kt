package com.ofal.ihsan.sub.utils

import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 13, September, 2018
 * ------------------------------
 * This class for context provider ui
 */
open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { UI }
}