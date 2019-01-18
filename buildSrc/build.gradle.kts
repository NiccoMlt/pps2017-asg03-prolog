import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("http://dl.bintray.com/typesafe/maven-releases") }
    jcenter()
}

plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}