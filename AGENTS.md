# AGENTS.md

## Overview
Obscura is a Java implementation of the OpenPGP standard (RFC 4880). It is educational: it provides exercises for the Secure Programming class at Vermont State University. Expect skeletal code, with placeholders and unimplemented methods. Keep the code clear and readable over clever or optimized.

**State:** early. `Main` only prints "Hello, World!". The `Packet` hierarchy and the String-to-Key (S2K) methods are stubs, and tests are skeletal (`TrivialTest`, `String2KeyTest`).

## Layout
- `pom.xml` – Maven build (groupId `edu.vermontstate.obscura`, Java source/target 1.8, UTF-8).
- `src/main/java/org/kelseymountain/obscura` – `Main`, `Packet` (interface), `PacketType` (enum), `String2Key`, `SymmetricKeyEncryptedSessionKeyPacket` (type 3), `SymmetricEncryptedIntegrityProtectedDataPacket` (type 18).
- `src/main/java/META-INF/MANIFEST.MF` – jar manifest (`Main-Class: edu.vermontstate.obscura.Main`). It lives under the source dir and is referenced by the jar plugin via `${project.build.sourceDirectory}`.
- `src/test/java/...` – JUnit 5 tests.
- `src/test/resources/` – `example.txt`, `example.txt.gpg` and `example.txt.asc`, made with GnuPG 2.2.17 using symmetric encryption. The passphrase is `Hello, World!`. Its README explains the byte layout.
- `doc/` – DocBook XML documentation (`Obscura.xml`, `Design.xml`, `Requirements.xml`, `User.xml`), an oXygen project file (`Obscura.xpr`) and `references/rfc4880.txt`.
- `TODO.md` – doc-build improvements (Saxon, using the Maven-downloaded DocBook XSL).

## Build and test (unverified)
Requires a JDK and Maven. The README documents these goals:
```
mvn compile              # compile
mvn test                 # compile and run JUnit 6 tests (surefire 2.22.1)
mvn package              # executable jar in target/
mvn javadoc:javadoc      # target/site/apidocs
mvn spotbugs:gui         # static analysis (GUI)
mvn exec:exec            # DocBook -> FO via Xalan; README says "Not Implemented!"
```
Notes:
- The doc build expects the DocBook XSL stylesheets manually installed at `doc/docbook-xsl-ns-1.76.1/`. That directory is git-ignored. The PDF step is not working.
- Dependencies: JUnit Jupiter 5.4.2 (test scope), plus xalan 2.7.2, fop 2.3 and docbook-xsl 1.79.1 for the doc build.
- Git-ignored: `/target/`, `doc/Obscura.fo`, `doc/Obscura.pdf`, `doc/docbook-xsl-ns-1.76.1/`, `.idea/`.
- The build tooling was not available when this file was written, so none of the commands above were run.

## Conventions
- Package `org.kelseymountain.obscura`. Keep new code in this package.
- Public types and methods carry Javadoc. Match the existing style.
- `Packet` is deliberately abstract. It does not expose raw bytes, and it has `getType()`, `write(OutputStream)` and a decode counterpart.
- Wrap lines at about 100 columns, as the existing sources and docs do. Use 4-space indentation.
- Don't commit IDE configuration. IntelliJ users import the Maven project.
- Keep large or incidental reference files out of `doc/references/`.

## Tips for agents
- RFC 4880 (`doc/references/rfc4880.txt`) is the authority for formats and algorithms.
- Use the sample files in `src/test/resources` as test vectors. The S2K type is Iterated and Salted (3), SHA-1, AES-128.
- Update the DocBook docs in `doc/` when changing design or requirements.
