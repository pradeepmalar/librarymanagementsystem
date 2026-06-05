plugins {
    java
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.library"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.0")
    implementation("com.mysql:mysql-connector-j:8.3.0")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.3.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}