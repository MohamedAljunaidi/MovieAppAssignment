import com.chainreaction.buildsrc.dependencies.DependencyGroups
import com.chainreaction.buildsrc.extensions.implementation
import com.chainreaction.buildsrc.dependencies.Dependencies
import com.chainreaction.buildsrc.extensions.kapt

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.chainreaction.buildsrc.common.base-android-library")
}

dependencies {
    implementation(DependencyGroups.navigationDependencies)
    implementation(DependencyGroups.androidDependencies)
    implementation(DependencyGroups.junitTestImplementationDependencies)
    implementation(DependencyGroups.junitAndroidTestImplementation)
    implementation(Dependencies.glide)
    kapt(Dependencies.glideCompiler)
    implementation(DependencyGroups.hiltDependencies)
    kapt(DependencyGroups.hiltKaptDependencies)
    implementation(DependencyGroups.sizeDependencies)}