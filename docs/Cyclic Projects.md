# Cyclic Projects
A Cyclic project is a collection of source files under a specified *source directory*, that are compiled and output under a specified *output directory*, possibly with dependencies on external JAR files and producing a built JAR file.

To compile a Cyclic project, run the Cyclic compiler with the arguments `-p "<path to project file>"`. Project files are written in YAML, and usually use the name `project.cyc.yaml`.

## YAML format
Project files are written in YAML. Each file defines a single project, with a single input and output folder, optional list of dependencies and output packages, and other project-wide options.

An example of a project file is:
```yaml
source: "cyclic/"
output: "../../build/classes/cyclic/"

jdk: 17
include_debug: false

dependencies:
- location: "../libs/cyclic_lib-0.0.1.jar"
  type: "jar"

packages:
- name: "my_cool_lib"
  version: "1.0.0"
  type: "jar"
  location: "../../libs/"
```

`source` and `output` define the input and output root folders, relative to the project file. Input file packages are expected to match the file structure after this folder, and compiled classes are placed in the output folder according to their package names. `./` and `../` can be used in these paths.

`dependencies` is a list of dependencies this project has, where extra types and symbols are loaded from. `packages` is a list of packages that this project should be packaged into. Elements in both of these lists have the same properties:
- `type`: The type of the package. Only `jar` is currently valid, though support for `jmod` files (for compiling against other JVMs) and (publishing to) online packages is considered.
- `location`: Where to find or put this package. For an output package, this is relative to the output root; for a dependency, this is relative to the project file.
- `name`: The name of the package. Ignored for dependencies; used as part of the file name of output packages.
- `version`: The version of the package. Ignored for dependencies; used as part of the file name of output packages.

There are a few other attributes that can be specified:
- `jdk`: The major JDK version that this project should be compiled on, equal to the compiler's JDK version by default. Since the compiler always compiles against the version of the JDK it's running on, the compiler will simply refuse to compile a project with a mismatching JDK version.
- `include_debug`: Whether to include debug symbols (parameter names and line numbers) in compiled code, `true` by default. (Note: This may become a package-specific option in the future.)
- `cyclic_lib`: The version of the Cyclic library to compile against, equal to `jdk` by default. *This currently has no effect*, and you must specify a Cyclic library dependency yourself.
- `include_cyclic_lib_refs`: Whether to include references to the Cyclic library in compiled code, `true` by default. When compiling without a Cyclic library dependency or types present, the compiler may crash if this is not `true`. When enabled, Cyclic features that depend on standard library types may not be available.
- `default_imports`: A list of imports to be considered in every file of this project, such as `java.lang.*` or `cyclic.lang.CyclicFile`. Empty by default. (Note: `java.lang.*` is always considered a default import regardless of the values of this list.)