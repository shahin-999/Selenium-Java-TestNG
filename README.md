# Selenium with TestNG Automation Framework

A robust Java-based automation framework for web application testing using Selenium WebDriver and TestNG. This framework follows the Page Object Model (POM) design pattern and incorporates best practices for test automation.

## Features

- Page Object Model (POM) implementation
- ExtentReports integration for detailed test reporting
- Log4j2 for comprehensive logging
- WebDriverManager for automatic driver management
- Data-driven testing support
- Parallel test execution
- Screenshot capture on test failure
- Custom annotations and listeners
- Reusable utility methods

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Chrome/Firefox browser (for web automation)
- IDE (IntelliJ IDEA or Eclipse recommended)

## Project Structure

```
.
├── main/
│   ├── java/
│   │   └── com/
│   │       └── framework/
│   │           ├── base/         # Base classes and core framework components
│   │           │   ├── BaseTest.java
│   │           │   └── WebDriverFactory.java
│   │           ├── config/       # Configuration classes and utilities
│   │           │   ├── ConfigManager.java
│   │           │   └── TestConfig.java
│   │           ├── pages/        # Page Object Model classes
│   │           └── utils/        # Utility classes and helper methods
│   │               ├── FileUtils.java
│   │               ├── WaitUtils.java
│   │               └── ReportUtils.java
│   └── resources/                # Configuration files and resources
│       ├── log4j2.xml
│       └── config.properties
├── test/
│   ├── java/
│   │   └── com/
│   │       └── tests/           # Test classes and test suites
│   └── resources/               # Test resources and configuration
│       ├── testdata/           # Test data files
│       └── testng.xml         # TestNG configuration file
├── reports/                    # Test execution reports
├── target/                    # Compiled classes and build artifacts
└── pom.xml                    # Maven project configuration
```

## Configuration

The framework uses configuration files in the `resources` directory for:
- TestNG suite configuration (`testng.xml`)
- Log4j2 configuration (`log4j2.xml`)
- Test data and properties (`config.properties`)

### Key Configuration Parameters
- Browser type and version
- Implicit wait timeouts
- Page load timeouts
- Screenshot settings
- Report settings
- Test environment URLs

## Dependencies

- Selenium WebDriver 4.16.1
- TestNG 7.8.0
- ExtentReports 5.1.1
- Log4j2 2.22.1
- WebDriverManager 5.6.3
- Apache Commons IO 2.15.1
- Apache Commons Configuration 2.9.0
- Apache POI 5.2.3

## Getting Started

1. Clone the repository
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Configure your environment settings in `config.properties`
4. Update `testng.xml` with your test suite configuration

## Running Tests

### Basic Test Execution
```bash
mvn test
```

### Run Specific Test Suite
```bash
mvn test -DsuiteXmlFile=test/resources/testng.xml
```

### Run Tests in Parallel
```bash
mvn test -DthreadCount=3
```

### Run with Specific Browser
```bash
mvn test -Dbrowser=chrome
```

## Reports

Test execution reports are generated in the `reports` directory using ExtentReports. Reports include:
- Test execution summary
- Screenshots of failed tests
- Detailed test steps
- System information
- Environment details

## Best Practices

1. **Page Object Model**
   - Each page should have its own class
   - Use meaningful method names
   - Implement proper wait strategies

2. **Test Design**
   - Follow AAA pattern (Arrange, Act, Assert)
   - Use meaningful test names
   - Implement proper test data management

3. **Code Organization**
   - Follow Java naming conventions
   - Use proper access modifiers
   - Implement proper exception handling

4. **Logging**
   - Use appropriate log levels
   - Include meaningful log messages
   - Log important test steps

## Troubleshooting

Common issues and solutions:
1. **Driver Initialization Issues**
   - Check browser version compatibility
   - Verify WebDriverManager configuration
   - Check system PATH settings

2. **Test Failures**
   - Check element locators
   - Verify wait conditions
   - Review test data

3. **Report Generation Issues**
   - Check report directory permissions
   - Verify ExtentReports configuration
   - Check log file settings

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

### Code Style Guidelines
- Follow Java coding standards
- Use meaningful variable names
- Add proper documentation
- Include unit tests for new features

## Support

For support, please:
1. Check the troubleshooting section
2. Review the documentation
3. Create an issue in the repository 