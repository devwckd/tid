repositories {
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    api(project(":tid-core"))
    compileOnly("org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT")
}