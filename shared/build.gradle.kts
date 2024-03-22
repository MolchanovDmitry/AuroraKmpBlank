plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
}

group = "com.example.kmpblank"
version = "1.0"

kotlin {

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    js(IR) {
        moduleName = "shared"
        binaries.executable()
        browser()
        binaries.library()
        nodejs()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(npm("uuid", "9.0.0"))
            }
        }
    }
}

android {
    namespace = "com.example.kmpblank"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

tasks.register("jsBuildForAurora") {
    dependsOn("jsBrowserProductionWebpack")
    doLast {
        copy {
            from(layout.buildDirectory.dir("dist/js/productionExecutable"))
            into("${rootProject.rootDir}/auroraApp/qml/kmp")
        }
    }
}