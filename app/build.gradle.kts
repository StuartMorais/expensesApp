plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.9.0-1.0.11"
//    id("com.google.dagger.hilt.android")
    id("com.google.dagger.hilt.android") version "2.41" apply false
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    implementation(libs.hilt.android.v248)
    ksp(libs.hilt.compiler)

    implementation(libs.hilt.android.v248)
    ksp(libs.hilt.compiler)

    implementation(libs.androidx.hilt.navigation.compose.v110)
    implementation(libs.androidx.material3.v110)
}

apply(plugin = "dagger.hilt.android.plugin")
