plugins {
    id("java")
    application
    id("pmd")
    id("jacoco")
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit for testing
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.3")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.11.4")
    testImplementation("org.mockito:mockito-core:3.6.28")
    testImplementation("org.mockito:mockito-junit-jupiter:4.11.0")

    // Kotlin dependencies
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")

    // Logging
    implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("ch.qos.logback:logback-classic:1.4.12")

    // Web framework
    implementation("com.sparkjava:spark-core:2.9.4")

    // JSON processing
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.0")
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.0")

    // Utility and Lombok
    implementation("org.projectlombok:lombok:1.18.28")
    implementation("io.github.cdimascio:dotenv-java:3.1.0")

    // Database and connection pooling
    implementation("com.zaxxer:HikariCP:5.1.0")
    implementation("org.postgresql:postgresql:42.6.0")

    // Security and JWT
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")
    implementation("org.mindrot:jbcrypt:0.4")

    // Web scraping
    implementation("org.jsoup:jsoup:1.17.2")

    // ONNX Runtime
    implementation("com.microsoft.onnxruntime:onnxruntime:1.15.0")

    // Hugging Face tokenizers
    implementation("ai.djl.huggingface:tokenizers:0.30.0")
}

pmd {
    isConsoleOutput = true
    toolVersion = "7.0.0"
    rulesMinimumPriority = 5
    ruleSets = listOf("category/java/errorprone.xml", "category/java/bestpractices.xml")
    threads = 6
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(22)
}
