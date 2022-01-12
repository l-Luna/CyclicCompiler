# Cyclic Compiler
A compiler for a Java-like pet JVM language, Cyclic.

Cyclic is effectively "my take on Java", and borrows most of it's syntax for regular code (i.e. classes and interfaces), while hopefully avoiding it's more confusing or legacy components, and making currently-hardcoded parts of the language more applicable to user types *without hurting readability* like I feel other JVM languages tend to do.

It's currently missing a lot: you won't find generics, lambdas, or working enums and records here yet. For regular classes and interfaces, though, the core functionality should be largely there.

While the full Java module system isn't present, there is a simple YAML-based format for defining a project; with an associated input and output folder, set of jar dependencies, required JDK version, and output jars.

There is no proper spec or grammar for Cyclic yet; it's still changing, as important parts of the language get implemented. The existing grammar is fairly messy in its current state.

This uses ANTLR4 to parse source files, SnakeYAML to parse project YAML files, and ASM to read and write class files.
