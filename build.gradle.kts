plugins {
    kotlin("jvm") version "2.3.0-Beta2"
    id("com.gradleup.shadow") version "8.3.0"
}

group = "net.underlords"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.minestom:minestom:2025.10.31-1.21.10")
    implementation("org.slf4j:slf4j-simple:2.0.17")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25)) // Minestom has a minimum Java version of 25
    }
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "net.underlords.MainKt" // Change this to your main class
        }
    }

    build {
        dependsOn(shadowJar)
    }
    shadowJar {
        mergeServiceFiles()
        archiveClassifier.set("") // Prevent the -all suffix on the shadowjar file.
    }
}