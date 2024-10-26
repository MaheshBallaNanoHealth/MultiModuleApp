import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.vanniktech.maven.publish") version "0.30.0"
}
mavenPublishing {
    // when publishing to https://central.sonatype.com/
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    coordinates("com.nanohealthplan.android", "nh_utility", "1.0.0")

    pom {
        name.set("NH Utility")
        description.set("This module provides a solid base for common functions you may need across various Android components.")
        inceptionYear.set("2024")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        url.set("https://github.com/MaheshBallaNanoHealth/MultiModuleApp.git")
        developers {
            developer {
                id.set("MaheshBallaNanoHealth")
                name.set("Mahesh NH")
                url.set("https://github.com/MaheshBallaNanoHealth")
            }
        }
        scm {
            url.set("https://github.com/MaheshBallaNanoHealth/MultiModuleApp.git")
            connection.set("scm:git:git://MaheshBallaNanoHealth/MultiModuleApp.git")
            developerConnection.set("scm:git:ssh://git@github.com:MaheshBallaNanoHealth/MultiModuleApp.git")

        }
    }
}

android {
    namespace = "com.nh_utility"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}