plugins {
    java
    id("maven-publish")
}

group = "org.loudsi"
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

    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            //url = uri("https://gitlab.com/api/v4/projects/19495568/packages/maven")
            url = uri("https://gitlab.com/api/v4/groups/org.loudsi/-/packages/maven"
            credentials(HttpHeaderCredentials::class) {
                name = "Job-Token"
                value = CI_TOKEN
            }
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }
}


