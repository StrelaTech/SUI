plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.android.kmp.library) apply false
    alias(libs.plugins.compose.multiplatform) apply false
    alias(libs.plugins.compose.compiler) apply false
}

// Coordinates used when SUI is consumed from another build (including a
// Gradle composite build): `com.strela.sui:kit`.
allprojects {
    group = "com.strela.sui"
    version = "0.1.0"
}
