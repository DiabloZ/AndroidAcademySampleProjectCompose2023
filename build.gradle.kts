buildscript {
    extra.apply {
        set("compose_version", "1.4.3")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "7.4.1" apply false
    id ("com.android.library") version "7.4.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.8.10" apply false
    kotlin("kapt") version "1.8.10"
}