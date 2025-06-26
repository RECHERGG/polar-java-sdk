plugins {
    java
}

group = "de.rechergg"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor(libs.bundles.utils)
    implementation(libs.bundles.logging)
    implementation(libs.bundles.utils)
    implementation(libs.okhttp)
    implementation(libs.gson)
    implementation(libs.databind)

    testAnnotationProcessor(libs.bundles.utils)
    testImplementation(platform("org.junit:junit-bom:5.13.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}