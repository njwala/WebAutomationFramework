# WebAutomationFramework

A flexible and dynamic Java-based test automation framework for web applications built on Selenium WebDriver and TestNG. This framework provides comprehensive capabilities for creating robust, scalable, and maintainable automated tests with support for multiple data sources, cloud execution, and advanced reporting.

## 🎯 Overview

WebAutomationFramework is designed to streamline web application testing by providing:
- **Multiple Data Source Integration** - Read test data from Config, CSV, Excel, and JSON files
- **Cloud & CLI Execution** - Run tests on cloud platforms and from command line
- **Headless Mode Support** - Execute tests without GUI for CI/CD pipelines
- **Advanced Reporting** - Generate detailed test reports with logs and screenshots
- **TestNG Integration** - Leverage TestNG features for test execution control and management

## ✨ Key Features

### 1. **Multi-Format Data Management**
- **Config Files** - Load application configuration and environment-specific settings
- **CSV Files** - Support for comma-separated value test data
- **Excel Files** - Read test data from XLS/XLSX files with multiple sheet support
- **JSON Files** - Parse JSON structured test data
- **Utilities** - Pre-built utilities to seamlessly integrate test data into test cases

### 2. **Robust Testing Capabilities**
- **Selenium WebDriver Integration** - Industry-standard browser automation
- **Cross-Browser Testing** - Execute tests on multiple browsers
- **Headless Mode** - Run tests without browser UI for faster execution
- **Cloud Testing** - Execute tests on cloud platforms (BrowserStack, Sauce Labs, etc.)

### 3. **Comprehensive Reporting & Logging**
- **Test Reports** - Detailed HTML reports with test execution summary
- **Logs** - Granular logging at each step for debugging
- **Screenshots** - Automatic capture of screenshots on test failures
- **Evidence Tracking** - Complete audit trail of test execution

### 4. **TestNG Framework Features**
- **Annotations** - `@Test`, `@BeforeMethod`, `@AfterMethod`, etc. for execution control
- **Parameterization** - Run tests with multiple data sets using `@Parameters`
- **Thread Management** - Configure parallel execution with thread count control
- **Listeners** - Custom listeners for test lifecycle events and reporting
- **Test Groups** - Organize and execute tests by functional groups
- **Dependencies** - Set test execution order and dependencies

### 5. **Flexible Execution Options**
- **IDE Execution** - Run tests directly from your IDE (Eclipse, IntelliJ)
- **Command Line (CLI)** - Execute tests via command line with custom configurations
- **CI/CD Integration** - Seamless integration with Jenkins, GitLab CI, GitHub Actions, etc.
- **Local Testing** - Run tests on local machines with configured browsers
- **Cloud Execution** - Execute tests on remote cloud infrastructure

## 🏗️ Architecture
WebAutomationFramework/ ├── src/ │ ├── main/ │ │ └── java/ │ │ └── com/automation/ │ │ ├── base/ # Base test classes │ │ ├── utils/ # Utility classes for data reading, reporting │ │ ├── pages/ # Page Object Model classes │ │ ├── listeners/ # TestNG listeners │ │ └── config/ # Configuration management │ │ │ └── test/ │ └── java/ │ └── com/automation/ │ └── tests/ # Test classes │ ├── resources/ │ ├── config/ # Configuration files │ ├── testdata/ │ │ ├── *.csv # CSV test data │ │ ├── *.xlsx # Excel test data │ │ └── *.json # JSON test data │ ├── reports/ # Generated test reports │ └── screenshots/ # Failure screenshots │ ├── testng.xml # TestNG configuration └── pom.xml # Maven dependencies



## 🚀 Quick Start

### Prerequisites
- Java 8 or higher
- Maven 3.6+
- Browser drivers (ChromeDriver, GeckoDriver, etc.) or use WebDriverManager

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/njwala/WebAutomationFramework.git
   cd WebAutomationFramework



2.Install Dependencies

bash
mvn clean install

3.Configure Test Data

Add your test data files in resources/testdata/
Update configuration files in resources/config/


Running Tests
From IDE
           Right-click on testng.xml and select "Run as TestNG Suite"
From Command Line

# Run all tests
mvn clean test

# Run specific test class
mvn clean test -Dtest=YourTestClass

# Run specific test method
mvn clean test -Dtest=YourTestClass#testMethod

# Run with specific configuration
mvn clean test -Denvironment=staging -Dbrowser=chrome -Dheadless=true

#Headless Mode
  bash
mvn clean test -Dheadless=true

#Parallel Execution
Configure in testng.xml:
   <suite name="AutomationSuite" parallel="methods" thread-count="5">
    ...
</suite>


📊 Data Sources Usage
   CSV Files
       Java
   List<String[]> testData = DataUtils.readCSV("testdata/users.csv");


