plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "2.1.0-1.0.29"
    id("com.google.dagger.hilt.android") version "2.41" apply false
    id("kotlin-kapt")
}

android {
    namespace = "com.example.expensesapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.expensesapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.monitor)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.testng)
    androidTestImplementation(libs.testng)
    ksp(libs.androidx.room.compiler)

    implementation(libs.hilt.android.v248)
    ksp(libs.hilt.compiler)

    implementation(libs.hilt.android.v241)
    kapt(libs.hilt.android.compiler)

    implementation(libs.hilt.android.v248)
    ksp(libs.hilt.compiler)

    implementation(libs.androidx.hilt.navigation.compose.v110)
    implementation(libs.androidx.material3.v110)
}

apply(plugin = "dagger.hilt.android.plugin")
