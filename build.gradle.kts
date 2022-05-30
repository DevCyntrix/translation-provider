plugins {
    `java-library`
    `maven-publish`
}

group = "de.devcyntrix"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:20.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    implementation("org.apache.commons:commons-text:1.9")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}