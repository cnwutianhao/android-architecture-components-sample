plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.COMPILE_SDK

    defaultConfig {
        applicationId = "com.tyhoo.nba"
        minSdk = Apps.MIN_SDK
        targetSdk = Apps.TARGET_SDK
        versionCode = Apps.VERSION_CODE
        versionName = Apps.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Room，配置编译器
        // https://developer.android.com/jetpack/androidx/releases/room?hl=zh_cn#compiler-options
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }
    }

    buildTypes {
        getByName("release") {
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

    kotlinOptions.jvmTarget = "1.8"

    // Data Binding support.
    buildFeatures.dataBinding = true
}

dependencies {
    // Kotlin lang.
    implementation(Libs.coreKtx)
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)

    // App compat and UI things.
    implementation(Libs.appcompat)
    implementation(Libs.constraintLayout)
    implementation(Libs.fragmentKtx)
    implementation(Libs.viewpager2)
    implementation(Libs.material)

    // LiveData library.
    implementation(Libs.lifecycleLivedata)
    implementation(Libs.lifecycleRuntime)
    implementation(Libs.lifecycleViewmodel)
    implementation(Libs.lifecycleCommon)

    // Navigation library.
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)

    // Room library.
    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)

    // Hilt library.
    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltAndroidCompiler)

    // Retrofit library.
    implementation(Libs.retrofit)
    implementation(Libs.retrofitConverterGson)

    // OkHttp logging library.
    implementation(Libs.okhttp)
    implementation(Libs.okhttpLoggingInterceptor)

    // Glide library.
    implementation(Libs.glide)
    kapt(Libs.glideCompiler)

    // Test.
    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.extJunit)
    androidTestImplementation(TestLibs.espresso)
}