import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.repositories
import Config.Versions
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
}

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("http://dl.bintray.com/typesafe/maven-releases") }
    jcenter()
}

group = Config.Proj.group
version = Config.Proj.version
description = Config.Proj.description

dependencies {
    testImplementation("junit:junit:${Versions.jUnit4}")

    // Logger runtime dependencies
    implementation("org.slf4j:slf4j-api:${Versions.slf4j}")
    implementation("ch.qos.logback:logback-core:${Versions.logback}")
    runtimeClasspath("ch.qos.logback:logback-classic:${Versions.logback}")
    testRuntimeClasspath("ch.qos.logback:logback-classic:${Versions.logback}")

    // Libraries
    implementation("it.unibo.alice.tuprolog:tuprolog:${Versions.tuprolog}")
}

java {
    sourceCompatibility = Versions.jdk
    targetCompatibility = Versions.jdk
    sourceSets["main"].resources.srcDir("src/main/prolog")
    sourceSets["test"].resources.srcDir("src/test/prolog")
}

tasks.named<Test>("test") {
    useJUnit()
    failFast = true
    testLogging {
        events = setOf(
                TestLogEvent.PASSED,
                TestLogEvent.SKIPPED,
                TestLogEvent.FAILED,
                TestLogEvent.STANDARD_ERROR)
    }
    reports {
        html.isEnabled = true
        junitXml.isEnabled = true
    }
}
