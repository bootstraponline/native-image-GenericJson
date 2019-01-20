import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
}

group = "gtest"
version = "SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // yaml parsing
    // https://github.com/FasterXML/jackson-core/releases
    val jackson = "2.9.8"
    implementation("com.fasterxml.jackson.core:jackson-databind:$jackson")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jackson")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jackson")

    // Google APIs
    // https://search.maven.org/search?q=a:google-cloud-storage%20g:com.google.cloud
    implementation("com.google.cloud:google-cloud-storage:1.60.0")

    // https://search.maven.org/search?q=a:google-api-services-toolresults%20g:com.google.apis
    implementation("com.google.apis:google-api-services-toolresults:v1beta3-rev20181112-1.28.0")

    // https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.google.apis%22%20AND%20a%3A%22google-api-services-testing%22
    implementation("com.google.apis:google-api-services-testing:v1-rev20190107-1.28.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

task("fatJar", type = Jar::class) {
    manifest {
        attributes.apply {
            put("Main-Class", "gtest.Main")
        }
    }

    from(configurations["runtimeClasspath"].map { file ->
        if (file.isDirectory) file else zipTree(file)
    })
    with(tasks["jar"] as CopySpec)
}
