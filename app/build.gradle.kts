import com.chainreaction.buildsrc.common.BaseGradle
import com.chainreaction.buildsrc.common.AppConfig
import com.chainreaction.buildsrc.dependencies.DependencyGroups
import com.chainreaction.buildsrc.extensions.implementation
import com.chainreaction.buildsrc.extensions.kapt
import com.chainreaction.buildsrc.dependencies.Dependencies

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    BaseGradle.appGradle(this, project = project)
    kotlinOptions {
        jvmTarget = AppConfig.AppConfigConstant.JVM_TARGET
    }
}

dependencies {
    implementation(project(AppConfig.ModulePathsConstant.CORE))
    implementation(project(AppConfig.ModulePathsConstant.CACHING))
    implementation(project(AppConfig.ModulePathsConstant.NETWORK))

    implementation(DependencyGroups.navigationDependencies)
    implementation(Dependencies.splashComponent)
    implementation(DependencyGroups.retrofitDependencies)
    implementation(DependencyGroups.androidDependencies)
    implementation(DependencyGroups.constraintDependencies)
    implementation(DependencyGroups.hiltDependencies)
    implementation(DependencyGroups.sizeDependencies)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    kapt(DependencyGroups.hiltKaptDependencies)
    implementation(DependencyGroups.constraintDependencies)
    implementation(DependencyGroups.junitTestImplementationDependencies)
    implementation(DependencyGroups.junitAndroidTestImplementation)
}