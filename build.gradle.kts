plugins {
    java
    id("maven-publish")
}

group = "org.loudsi"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven {
        url = uri("https://gitlab.com/api/v4/projects/19495568/packages/maven")
        name = "GitLab"

       /* authentication {
            credentials(HttpHeaderCredentials::class) {
                name = "Job-Token"
                value = "${CI_JOB_TOKEN}"
            }
        }*/

    }
}

tasks.test { useJUnitPlatform() }
dependencies {
    implementation("io.github.kostaskougios:cloning:1.10.3")
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.2")
}

