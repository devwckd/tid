plugins {
    id("java")
    id("java-library")
    id("maven-publish")
    id("signing")
}

allprojects {
    group = "me.devwckd.tid"
    version = "0.1.0"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
}