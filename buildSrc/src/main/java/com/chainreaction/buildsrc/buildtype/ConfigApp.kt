package com.chainreaction.buildsrc.buildtype

import com.android.build.api.dsl.BuildType
import com.chainreaction.buildsrc.common.AppConfig
import com.chainreaction.buildsrc.extensions.buildConfigStringField
import java.util.*

/**
 * The `ConfigApp` class to set up our configurations,
 * such as buildConfigField and manifestPlaceholders.
 */

object ConfigApp {

    fun initConfigData(buildType: BuildType, properties: Properties) {

        buildType.apply {

            //base URL
            buildConfigStringField(
                AppConfig.BuildConfigField.BASE_URL_KEY,
                properties.getProperty(AppConfig.BuildConfigField.BASE_URL_VALUE)
            )

        }
    }
}