pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

/*    dependencies {
        classpath(libs.androidGradle)
        classpath(libs.kotlinGradle)
        classpath(libs.hiltGradle)
        classpath(libs.googleServicesGradle)
    }*/
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "AndroidAcademySampleProjectCompose2023"
include (":app")
