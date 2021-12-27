plugins {
    java
}

group = "com.github.l-Luna.CyclicCompiler"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.antlr:antlr4-runtime:4.9.3")
    implementation("org.ow2.asm:asm:9.2")
    implementation("org.jetbrains:annotations:22.0.0")
    
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}