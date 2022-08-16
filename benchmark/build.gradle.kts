plugins {
    id("java")
}

group = "com.github.l-Luna.CyclicCompiler"
version = "0.0.4"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":"))
    
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test"){
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