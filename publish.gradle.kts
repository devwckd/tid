apply(plugin = "maven-publish")
apply(plugin = "signing")

val isReleaseVersion = !version.toString().endsWith("SNAPSHOT")

configure<PublishingExtension> {
    publications {
        create<MavenPublication>(project.name.removePrefix("tid-")) {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            from(components["java"])

            pom {
                name.set(project.name)
                description.set(project.description)
                url.set("https://github.com/devwckd/tid")
                inceptionYear.set("2023")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/devwckd/tid/blob/main/LICENSE-MIT")
                    }
                }

                developers {
                    developer {
                        name.set("João Victor Gomides Cruz")
                        email.set("dev.wckd@gmail.com")
                        url.set("https://github.com/devwckd")
                    }
                }

                scm {
                    connection.set("scm:git:git:github.com/devwckd/tid.git")
                    developerConnection.set("scm:git:https://github.com/devwckd/tid.git")
                    url.set("https://github.com/devwckd/tid")
                }
            }
        }
    }

    repositories {
        maven {
            name = "OSSRH"
            url = if (isReleaseVersion)
                uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            else
                uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")

            credentials {
                username = (project.findProperty("ossrhUsername") ?: System.getenv("OSSRH_USERNAME")).toString()
                password = (project.findProperty("ossrhPassword") ?: System.getenv("OSSRH_PASSWORD")).toString()
            }
        }
    }
}


configure<SigningExtension> {
    isRequired = isReleaseVersion && gradle.taskGraph.hasTask("uploadArchives")

    sign(extensions.getByType(PublishingExtension::class.java).publications.findByName(project.name.removePrefix("tid-")))
}