plugins {
    java
}
java{

}
group =  "org.loudsi"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

tasks.test { useJUnitPlatform() }
dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.4")
    implementation("io.github.kostaskougios:cloning:1.10.3")
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.2")
}

