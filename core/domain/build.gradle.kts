plugins {
    alias(libs.plugins.kotlin)
}


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies{
    implementation(libs.kotlinx.coroutines.android)
}

