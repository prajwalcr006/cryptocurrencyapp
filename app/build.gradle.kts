plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.9.23"
}

android {
    namespace = "com.example.cryptocurrencyapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cryptocurrencyapp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    //retrofit implementation
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")

    //dependency injection
    implementation("com.google.dagger:dagger:2.44")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.51")

    //Koin
    implementation("io.insert-koin:koin-android:3.2.0")

    //gson converter factory
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //viewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    //recycler_view
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    //constraint layout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //card view
    implementation("androidx.cardview:cardview:1.0.0")

    //search view
    implementation("androidx.appcompat:appcompat:1.6.1")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")



}