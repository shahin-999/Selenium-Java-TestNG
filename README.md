# Automation Framework

A Java-based automation framework for web application testing and API testing.

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher (if using database features)
- Chrome/Firefox browser (for web automation)

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── framework/
│   │           ├── config/
│   │           ├── pages/
│   │           ├── utils/
│   │           └── tests/
│   └── resources/
│       └── config.properties
├── test/
│   └── java/
│       └── com/
│           └── framework/
│               └── tests/
└── pom.xml
```

## Configuration

The framework uses `config.properties` for configuration. Key settings include:

- Environment configuration (dev, qa, prod)
- Browser settings
- Timeout configurations
- Database connection details
- Logging settings
- API configurations

## Dependencies

- Selenium WebDriver
- TestNG
- Log4j
- MySQL Connector
- Apache Commons

## Getting Started

1. Clone the repository
2. Update `config.properties` with your environment settings
3. Run the following command to install dependencies:
   ```bash
   mvn clean install
   ```

## Running Tests

To run tests using Maven:

```bash
mvn test
```

To run specific test suites:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Logging

The framework uses Log4j for logging. Logs are stored in the `logs` directory.

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 