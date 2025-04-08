# My First Application

This is a simple Java application built using Maven. Below are the instructions on how to build and run the application.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6 or higher

## Building the Application

To build the application, navigate to the project directory and run the following command:

```
mvn clean install
```

This will compile the source code, run tests, and package the application into a JAR file.

## Running the Application

After building the application, you can run it using the following command:

```
java -cp target/my-first-application-1.0-SNAPSHOT.jar com.example.App
```

Replace `my-first-application-1.0-SNAPSHOT.jar` with the actual name of the JAR file generated in the `target` directory.

## Running Tests

To run the tests, use the following command:

```
mvn test
```

This will execute the unit tests defined in the `src/test/java` directory.

## Project Structure

```
my-first-application
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── App.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── AppTest.java
│       └── resources
├── pom.xml
└── README.md
```

## License

This project is licensed under the MIT License.