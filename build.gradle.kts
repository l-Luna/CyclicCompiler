plugins{
    java
    antlr
}

group = "com.github.l-Luna.CyclicCompiler"
version = "0.0.4"

repositories{
    mavenCentral()
}

dependencies{
	implementation("org.antlr:antlr4-runtime:4.11.1")
	implementation("org.ow2.asm:asm:9.4")
	implementation("org.jetbrains:annotations:23.0.0")
	implementation("org.yaml:snakeyaml:1.33")
	
	antlr("org.antlr:antlr4:4.11.1")
	
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
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

tasks.withType<Jar>{
    manifest {
        attributes["Main-Class"] = "cyclic.lang.compiler.CompilerLauncher"
    }
    configurations["compileClasspath"].forEach { file ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

tasks.generateGrammarSource{
    arguments = arguments + listOf("-visitor")
}