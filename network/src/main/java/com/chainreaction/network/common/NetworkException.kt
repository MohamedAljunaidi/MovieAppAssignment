package com.chainreaction.network.common

import com.chainreaction.core.bases.ResultException
import com.chainreaction.network.R

open class NetworkException(
    messageResource: Int = R.string.error_unexpected,
    cause: Throwable? = null
) : ResultException(messageResource, cause)