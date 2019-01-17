import org.gradle.api.JavaVersion

// The idea for this file comes from:
// https://expertise.jetruby.com/how-to-write-gradle-scripts-with-kotlin-dsl-better-than-groovy-a63ffc9be2e3

/** Specify dependencies and their versions. */
object Config {

    /** Values for project configurations. */
    object Proj {
        val group = "it.unibo.pps17"
        val artifactId = "asg03"
        val longName = "Assignment n.3"
        val description = "Paradigmi di Programmazione e Sviluppo - Assignment n.3 - Prolog"
        val version = "0.0.1"
    }

    /** Values for dependencies versions. */
    object Versions {
        // Java
        val java = "8"
        val jdk: JavaVersion = JavaVersion.toVersion("1.$java")

        // JUnit & Scalatest
        val jUnit4 = "4.12"

        // Libraries version
        val slf4j = "1.7.25"
        val logback = "1.2.3"
        val tuprolog = "3.3.0"
    }
}
