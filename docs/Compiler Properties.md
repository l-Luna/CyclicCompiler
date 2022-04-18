Compiler JARs should contain a `cyclic_compiler.properties` file in their root to allow external tools to
get information about the compiler.

The properties file should contain the following properties:
- `compiler.name`: The name of the compiler.
- `compiler.version`: The version of the compiler.
- `cyclic.version`: The supported language version.