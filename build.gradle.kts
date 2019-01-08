import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.repositories
import Config.Versions
import Config.Versions.scalaBinary
import Config.Versions.scalaTest
import org.gradle.api.tasks.testing.logging.TestLogEvent
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    scala
    application
    id("com.github.johnrengelman.shadow") version "4.0.3"
    id("com.github.maiflai.scalatest") version "0.23"
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
    implementation("org.scala-lang:scala-library:${Versions.scala}")
    implementation("org.scala-lang.modules:scala-java8-compat_$scalaBinary:${Versions.scalaCompat}")

    // JUnit 5 with 4.12 Vintage support
    testCompileOnly("junit:junit:${Versions.jUnit4}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.jUnit5}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${Versions.jUnit5}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.jUnit5}")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:${Versions.jUnit5}")

    testImplementation("org.scalatest:scalatest_$scalaBinary:${Versions.scalaTest}")
    testRuntimeOnly("org.scala-lang.modules:scala-xml_$scalaBinary:${Versions.scalaXML}")
    testRuntimeOnly("org.pegdown:pegdown:${Versions.pegdown}")
    implementation("org.scalactic:scalactic_$scalaBinary:${Versions.scalaTest}")

    // Logger runtime dependencies
    implementation("org.slf4j:slf4j-api:${Versions.slf4j}")
    implementation("ch.qos.logback:logback-core:${Versions.logback}")
    implementation("com.typesafe.scala-logging:scala-logging_$scalaBinary:${Versions.scalaLogging}")
    runtimeClasspath("ch.qos.logback:logback-classic:${Versions.logback}")
    testRuntimeClasspath("ch.qos.logback:logback-classic:${Versions.logback}")

    // Libraries
    implementation("com.github.scopt:scopt_$scalaBinary:${Versions.scopt}")
    implementation("org.scalaz:scalaz-core_$scalaBinary:${Versions.scalaz}")
}

java {
    sourceCompatibility = Versions.jdk
    targetCompatibility = Versions.jdk
}

application {
    mainClassName = "${Config.Proj.group}.${Config.Proj.artifactId}.Main"
}

@Suppress("UnstableApiUsage")
tasks.named<Test>("test") {
    useJUnitPlatform()
    failFast = true
    testLogging {
        events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED, TestLogEvent.STANDARD_ERROR)
    }
    reports {
        html.isEnabled = true
        junitXml.isEnabled = true
    }
    maxParallelForks = 1
}

tasks.withType(ScalaCompile::class) {
    scalaCompileOptions.additionalParameters = listOf("-deprecation")
}

tasks.withType(ShadowJar::class) {
    archiveBaseName.set(Config.Proj.artifactId)
    archiveVersion.set(Config.Proj.version)
    archiveClassifier.set(project.name)
}
