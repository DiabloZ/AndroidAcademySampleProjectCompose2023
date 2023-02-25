plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.suhov.aaspc2023"
    compileSdk = 33

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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes.add ("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation (libs.ktx.core)
    implementation (libs.ktx.runtime)
    implementation (libs.ktx.viewmodel)
    implementation (libs.compose.activity)
    implementation (libs.compose.preview)
    implementation (libs.compose.material)
    implementation (libs.compose.material3)
    implementation (libs.compose.materialIcons)
    debugImplementation (libs.compose.uiTooling)

    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.coil)

    implementation(libs.timber)

    /*implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)*/

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    implementation(libs.okhttp.loggingInterceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
}