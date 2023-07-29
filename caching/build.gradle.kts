import com.chainreaction.buildsrc.dependencies.Dependencies
import com.chainreaction.buildsrc.dependencies.DependencyGroups
import com.chainreaction.buildsrc.extensions.implementation
import com.chainreaction.buildsrc.common.AppConfig
import com.chainreaction.buildsrc.extensions.kapt

plugins {
    kotlin("kapt")
    id("com.chainreaction.buildsrc.common.base-android-library")
}
dependencies {
    implementation(project(AppConfig.ModulePathsConstant.CORE))

    implementation(DependencyGroups.hiltDependencies)
    kapt(DependencyGroups.hiltKaptDependencies)

    kapt(Dependencies.roomCompiler)
    implementation(DependencyGroups.roomDependencies)
    implementation(Dependencies.gson)

    implementation(DependencyGroups.androidDependencies)
    implementation(DependencyGroups.junitTestImplementationDependencies)
    implementation(DependencyGroups.junitAndroidTestImplementation)
}