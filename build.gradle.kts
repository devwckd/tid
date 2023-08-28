plugins {
    java
    `java-library`
    `maven-publish`
}

allprojects {
    group = "me.devwckd.tid"
    version = "0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")

    afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>(project.name.removePrefix("tid-")) {
                    groupId = project.group.toString()
                    artifactId = project.name
                    version = project.version.toString()
                    from(components["java"])
                }
            }
        }
    }
}