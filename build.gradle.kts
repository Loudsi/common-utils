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

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Loudsi/common-utils")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

