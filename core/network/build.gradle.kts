plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}
android {
    namespace = "com.calorie.calculator.network"
    compileSdk = libs.versions.androidSdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.androidSdk.min.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        buildConfigField("String", "API_URL", "\"https://price.jup.ag/v6/\"")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    //retrofit
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    //serialization
    implementation(libs.kotlinx.serialization.json)

    //okHttp
    implementation(libs.okhttp)

    //koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)

}