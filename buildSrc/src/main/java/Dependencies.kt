object Apps {
    const val COMPILE_SDK = 32
    const val MIN_SDK = 21
    const val TARGET_SDK = 32
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
}

object Versions {
    const val GRADLE = "7.0.4"
    const val KOTLIN = "1.6.0"
    const val KOTLIN_CORE = "1.7.0"
    const val KOTLIN_COROUTINES = "1.5.2"
    const val APPCOMPAT = "1.4.0"
    const val CONSTRAINT_LAYOUT = "2.1.2"
    const val FRAGMENT = "1.4.0"
    const val VIEWPAGER2 = "1.0.0"
    const val MATERIAL = "1.4.0"
    const val LIFECYCLE = "2.4.0"
    const val NAVIGATION = "2.3.5"
    const val ROOM = "2.3.0"
    const val HILT = "2.38.1"
    const val RETROFIT = "2.9.0"
    const val OKHTTP = "4.9.1"
    const val GLIDE = "4.12.0"
    const val JUNIT = "4.13.2"
    const val EXT_JUNIT = "1.1.3"
    const val ESPRESSO = "3.4.0"
}

object Libs {
    const val coreKtx =
        "androidx.core:core-ktx:${Versions.KOTLIN_CORE}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLIN_COROUTINES}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLIN_COROUTINES}"
    const val appcompat =
        "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val fragmentKtx =
        "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"
    const val viewpager2 =
        "androidx.viewpager2:viewpager2:${Versions.VIEWPAGER2}"
    const val material =
        "com.google.android.material:material:${Versions.MATERIAL}"
    const val lifecycleLivedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    const val lifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val lifecycleCommon =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val navigationUi =
        "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val roomRuntime =
        "androidx.room:room-runtime:${Versions.ROOM}"
    const val roomKtx =
        "androidx.room:room-ktx:${Versions.ROOM}"
    const val roomCompiler =
        "androidx.room:room-compiler:${Versions.ROOM}"
    const val hiltAndroid =
        "com.google.dagger:hilt-android:${Versions.HILT}"
    const val hiltAndroidCompiler =
        "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val retrofit =
        "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val retrofitConverterGson =
        "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val okhttp =
        "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val glide =
        "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val glideCompiler =
        "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.JUNIT}"
    const val extJunit = "androidx.test.ext:junit:${Versions.EXT_JUNIT}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
}