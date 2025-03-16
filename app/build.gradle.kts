plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.devtools.ksp")
    id ("kotlin-kapt")
}

android {
    namespace = "com.suhov.aaspc2023"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.suhov.aaspc2023"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {

        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        debug {
            isMinifyEnabled = false
            isShrinkResources = false
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }

    packagingOptions {
        resources {
            excludes.add ("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/${name}/kotlin")
            }
        }
    }
}

dependencies {

    implementation (libs.ktx.core)
    implementation (libs.ktx.runtime)

    implementation (libs.compose.activity)
    implementation (libs.compose.preview)
    implementation (libs.compose.material)
    implementation (libs.compose.material3)
    implementation (libs.compose.materialIcons)
    implementation (libs.compose.viewmodel)
    implementation(libs.compose.navigation)

    debugImplementation (libs.compose.uiTooling)

    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.coil)

    implementation(libs.timber)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    implementation(libs.okhttp.loggingInterceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    testImplementation (libs.test.junit)
    androidTestImplementation (libs.test.junit.ext)
    androidTestImplementation (libs.test.espresso)

    implementation (libs.koin.android)
    implementation (libs.koin.compose)
    implementation (libs.koin.annotations)
    ksp (libs.koin.compiler)

    //implementation(libs.dagger.android)
    //implementation(libs.dagger.android.processor)
    //implementation(libs.dagger.android.support)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}