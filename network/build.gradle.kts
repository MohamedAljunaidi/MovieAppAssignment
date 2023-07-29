import com.chainreaction.buildsrc.common.AppConfig
import com.chainreaction.buildsrc.dependencies.DependencyGroups
import com.chainreaction.buildsrc.extensions.implementation
import com.chainreaction.buildsrc.extensions.kapt

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.chainreaction.buildsrc.common.base-android-library")
}

dependencies {
    implementation(project(AppConfig.ModulePathsConstant.CORE))

    implementation(DependencyGroups.coroutinesDependencies)
    implementation(DependencyGroups.retrofitDependencies)
    implementation(DependencyGroups.hiltDependencies)
    kapt(DependencyGroups.hiltKaptDependencies)

    implementation(DependencyGroups.androidDependencies)
    implementation(DependencyGroups.junitTestImplementationDependencies)
    implementation(DependencyGroups.junitAndroidTestImplementation)
}