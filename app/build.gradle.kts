plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("kotlinx-serialization")
}

android {
    namespace = "com.nbscollege.fitnessapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nbscollege.fitnessapp"
        minSdk = 26
        targetSdk = 33
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.compose.material:material-icons-extended:1.5.3")
    implementation("androidx.wear.compose:compose-material:1.2.1")


    val nav_version = "2.7.4"

    implementation("androidx.navigation:navigation-compose:$nav_version")
    // Splash screen
    implementation("androidx.core:core-splashscreen:1.0.1")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation ("me.onebone:toolbar-compose:2.1.0")

    val room_version = "2.6.0"

    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.core:core-ktx:1.10.1")
    ksp("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    implementation ("io.coil-kt:coil:1.3.0")
    implementation ("io.coil-kt:coil-compose:1.3.0")

    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    //lottie
    implementation ("com.airbnb.android:lottie-compose:6.0.0")


//    lottie ulit pero animation view
//    implementation ("com.airbnb.android:lottie:4.2.0")

    implementation ("com.jakewharton.timber:timber:5.0.1")
    // ktor for networking
    val ktor_version = "2.2.2"
    implementation ("io.ktor:ktor-client-core:$ktor_version")
    implementation ("io.ktor:ktor-client-android:$ktor_version")
    implementation ("io.ktor:ktor-client-serialization:$ktor_version")
    implementation ("io.ktor:ktor-client-logging:$ktor_version")
    implementation ("io.ktor:ktor-client-auth:$ktor_version")
    implementation ("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation ("io.ktor:ktor-server-http-redirect:$ktor_version")

    //Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.45")
    ksp ("com.google.dagger:hilt-android-compiler:2.45")
    ksp ("androidx.hilt:hilt-compiler:1.0.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation ("com.google.dagger:dagger-android-support:2.45")
    implementation( "io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")





}