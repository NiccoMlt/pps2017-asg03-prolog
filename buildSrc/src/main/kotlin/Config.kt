import org.gradle.api.JavaVersion

// The idea for this file comes from:
// https://expertise.jetruby.com/how-to-write-gradle-scripts-with-kotlin-dsl-better-than-groovy-a63ffc9be2e3

/** Specify dependencies and their versions. */
object Config {

    object Proj {
        val group = "it.unibo.pps17"
        val artifactId = "sudoku"
        val longName = "Sudoku"
        val description = "Sudoku application with prolog"
        val version = "0.0.1"
    }

    /** Values for dependencies versions. */
    object Versions {
        // Java
        val java = "8"
        val jdk: JavaVersion = JavaVersion.toVersion("1.$java")

        // Scala
        val scalaBinary = "2.12"
        val scalaMinor = "7"
        val scala = "$scalaBinary.$scalaMinor"
        val scalaCompat = "0.9.0"

        // JUnit & Scalatest
        val jUnit4 = "4.12"
        val jUnit5 = "5.3.1"
        val scalaTest = "3.0.5"
        val scalaXML = "1.1.1"
        val pegdown = "1.6.0"

        // SCoverage variables
        val scalacSCoverage = "1.3.1"

        // Checkstyle variables
        val checkstyle = "8.0"

        // SpotBugs variables
        val spotBugs = "3.1.8"
        val findSecBugs = "1.7.1"
        val fbContrib = "7.4.1.sb"
        val slf4jBugPattern = "1.2.4"

        // Libraries versions
        val scopt = "3.7.0"
        val slf4j = "1.7.25"
        val logback = "1.2.3"
        val scalaLogging = "3.9.0"
        val scalaz = "7.2.27"
        val tuprolog = "3.3.0"
    }

    /** SpotBugs-related versions. */
    object SpotBugs {
        val version = Versions.spotBugs
        val effortLevel = "max"
        val reportLevel = "low"
    }
}
