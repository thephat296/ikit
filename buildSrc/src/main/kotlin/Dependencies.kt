/**
 * Created by phatvt2 on 8/4/20
 */

object Dependencies {
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"

    const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_DFM = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAVIGATION}"

    const val TEST_JUNIT = "junit:junit:${Versions.TEST_JUNIT}"

    const val ANDROID_TEST_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_TEST_JUNIT}"
    const val ANDROID_TEST_ESPRESSO_CORE = "androidx.test.ext:junit:${Versions.ANDROID_TEST_JUNIT}"
    const val ANDROID_TEST_ANNOTATION = "androidx.annotation:annotation:${Versions.ANNOTATION}"

    const val MODULE_APP = ":app"
}