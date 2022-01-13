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
    implementation("org.yaml:snakeyaml:1.30")
    
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    jvmArgs("--enable-preview")
}

tasks.withType<JavaExec>{
    jvmArgs("--enable-preview")
}

tasks.withType<JavaCompile>{
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<Javadoc>{
    val jdOptions = options as CoreJavadocOptions
    jdOptions.addStringOption("source", JavaVersion.VERSION_17.toString())
    jdOptions.addBooleanOption("-enable-preview", true)
}