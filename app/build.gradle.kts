plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //custom
    alias(libs.plugins.kotlin.serialization)
    //alias(libs.plugins.google.services)
    //hilt
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)

}




android {
    namespace = "com.example.DoctorYa"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.template_code"
        minSdk = 26
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
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,LICENSE.md,LICENSE-notice.md,LICENSE.txt}"
        }
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.junit.junit)
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
            //custom
    // Navigation Compose
    implementation(libs.navigation.compose)

     // Icon Material3 Extended
    implementation(libs.icon.extended)

     // Splash
    implementation(libs.splash)

     // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.ai)

    // Serialization
    implementation(libs.kotlinx.serialization.json)

    // Data Store
    implementation(libs.androidx.datastore.preferences)

    // hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation)
    //Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)

    // Si usas Paging 3 con Room
    implementation(libs.room.paging)

    // KSP  para el compilador
    ksp(libs.room.compiler)

    //Testing
    implementation(libs.mockk)
    implementation(libs.kotlin.coroutines)
    implementation(libs.turbine)
    testImplementation(libs.assertj)


     //nav3
    implementation(libs.nav3.runtime)
    implementation(libs.nav3.ui)
    implementation(libs.lifecycle.viewmodel.navigation3)
    implementation(libs.kotlinx.serialization.core)
}