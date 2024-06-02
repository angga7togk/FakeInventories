plugins {
    id("java")
}

group = "me.iwareq.fakeinventories"
version = "1.1.8"

repositories {
    mavenCentral()
    maven("https://repo.opencollab.dev/maven-releases")
    maven("https://repo.opencollab.dev/maven-snapshots")
    maven("https://repo.lanink.cn/repository/maven-public/")
}

dependencies {
    implementation("cn.nukkit:Nukkit:MOT-SNAPSHOT")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.withType<JavaCompile> {
    options.encoding = Charsets.UTF_8.name()
}

tasks.withType<ProcessResources> {
    filteringCharset = Charsets.UTF_8.name()
    filesMatching("plugin.yml") {
        expand("version" to version)
    }
}
