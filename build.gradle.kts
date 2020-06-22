plugins {
    java
    id("maven-publish")
}

group = "org.loudsi.common"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

tasks.test { useJUnitPlatform() }
dependencies {
    implementation("io.github.kostaskougios:cloning:1.10.3")
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.2")
}

val CI_TOKEN: String ? by project

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Loudsi/common-utils")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register("gpr") {
            from(components["java"])
        }
    }
}

