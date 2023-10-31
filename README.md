Obscura
=======

Obscura is a Java program that implements the OpenPGP standard. It is intended primarly as a
source of exercises and assignments for students in my Secure Programming class at Vermont State
University (as well as possibly other classes). Thus its primary purpose is educational.

Setting Up
----------

To get set up for doing Obscura development, follow these steps:

1. Install a suitable Git client for use with GitHub. There are several choices, depending on
   your development platform. On Linux systems you can just install the appropriate package and
   use the command line client.
   
2. Clone this repository using the Git URL available here.

3. If you don't want to bother with an IDE, be sure you have a modern version of Maven installed
   and in your path. You can then use the Maven goals described below.
   
4. If you want to use an IDE, be sure that it supports Maven integration. After installing your
   IDE, import the `pom` file in this project to get started. For IntelliJ, select "import
   project" from the menu on the opening screen, then be sure to select "import from an external
   model" using "Maven" as the model type. All other defaults should be fine.
   
Maven Goals
-----------

The following goals might be useful:

    mvn compile  # Compiles the program.
    mvn test     # Compiles and executes unit tests.
    mvn package  # Builds the executable jar file (in the target folder).
    mvn javadoc:javadoc  # Builds the Javadoc API documentation (in target/site/apidocs).
    mvn spotbugs:gui     # Executes the Spotbugs analysis tool in GUI mode.
    mvn exec:exec        # Builds PDF version of the main documentation (in doc) [Not Implemented!]

Peter Chapin  
spicacality@kelseymountain.org  
