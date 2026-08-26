## 🛠️ Technologies & Tools
| Technology / Tool  | Purpose                                     |
| ------------------ | ------------------------------------------- |
| Java               | Programming language                        |
| Selenium WebDriver | Web UI automation                           |
| TestNG             | Test execution and assertions               |
| Maven              | Build and dependency management             |
| WebDriverManager   | WebDriver setup                             |
| Page Object Model  | Framework design pattern                    |
| Git & GitHub       | Version control and source-code management  |
| Apache Commons IO  | Screenshot file handling                    |
| Java Properties    | External test-data/configuration management |


# OpenCart Selenium Automation Framework

## Selenium WebDriver automation framework built with Java, TestNG, and Maven** for automating key e-commerce workflows in the OpenCart demo application.

The framework follows the **Page Object Model (POM)** design pattern and focuses on reusable page actions, centralized WebDriver management, configuration management, explicit waits, organized test execution, and automatic failure screenshot capture.

## 📌 Project Overview

This project automates key OpenCart e-commerce workflows, including:

* Login
* User Registration
* Product Search
* Invalid Product Search
* Add Product to Cart
* Shopping Cart Validation
* Guest Checkout and Billing Details

The framework demonstrates maintainable Selenium automation using the Page Object Model, reusable page methods, explicit waits, centralized WebDriver management, external test data, data-driven testing, and failure screenshot capture.
---

## 🛠️ Technologies & Tools

|| Technology / Tool  | Purpose                                     |
| ------------------ | ------------------------------------------- |
| Java               | Programming language                        |
| Selenium WebDriver | Web UI automation                           |
| TestNG             | Test execution and assertions               |
| Maven              | Build and dependency management             |
| WebDriverManager   | WebDriver setup                             |
| Page Object Model  | Framework design pattern                    |
| Git & GitHub       | Version control and source-code management  |
| Apache Commons IO  | Screenshot file handling                    |
| Java Properties    | External test-data/configuration management |

---

## 🏗️ Framework Architecture

The framework follows the **Page Object Model** architecture.

### Core Components

* **BasePage** – Provides reusable Selenium actions and explicit-wait methods.
* **BaseTest** – Handles test setup and teardown.
* **DriverFactory** – Creates and manages the WebDriver instance.
* **ConfigReader** – Reads application configuration from `config.properties`.
* **Page Classes** – Encapsulate application locators and page-specific actions.
* **Test Classes** – Contain test scenarios and assertions.
* **ScreenshotUtil** – Captures screenshots when a test fails.
* **TestDataReader**– Reads test data from the external testdata.properties file.
* **testng.xml** – Defines the regression test suite.

### Framework Flow

```text
Test Class
    ↓
Page Object
    ↓
BasePage
    ↓
Selenium WebDriver
    ↓
OpenCart Application
```

---

## 📂 Project Structure

```text
opencart-automation
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.geeta.automation.opencart
│   │   │       ├── base
│   │   │       │   └── BasePage.java
│   │   │       ├── core
│   │   │       │   └── DriverFactory.java
│   │   │       ├── pages
│   │   │       │   ├── HomePage.java
│   │   │       │   ├── LoginPage.java
│   │   │       │   ├── RegisterPage.java
│   │   │       │   ├── SearchPage.java
│   │   │       │   ├── ProductPage.java
│   │   │       │   ├── CartPage.java
│   │   │       │   └── CheckoutPage.java
│   │   │       └── utils
│   │   │           ├── ConfigReader.java
│   │   │           ├── TestDataReader.java
│   │   │           └── ScreenshotUtil.java
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       ├── java
│       │   └── com.geeta.automation.opencart
│       │       ├── base
│       │       │   └── BaseTest.java
│       │       └── tests
│       │           ├── LoginTest.java
│       │           ├── RegisterTest.java
│       │           ├── SearchTest.java
│       │           ├── CartTest.java
│       │           └── CheckoutTest.java
│       └── resources
│           └── testData.properties
│
├── pom.xml
├── testng.xml
└── README.md
```

---

## 🧪 Automated Test Scenarios

### Login

- Navigate to the Login page
- Enter valid login credentials
- Submit login
- Verify successful login

### Registration

- Navigate to the Registration page
- Enter registration details
- Submit the registration form
- Validate the registration flow

### Product Search

- Search for a valid product
- Verify the product appears in the search results
- Search for an invalid product
- Verify the appropriate no-results message

### Shopping Cart

- Search for a product
- Open the product
- Add the product to the cart
- Navigate to the Shopping Cart
- Verify the Shopping Cart page
- Verify the product
- Verify quantity
- Verify unit price

### Guest Checkout

- Add a product to the cart
- Navigate to Checkout
- Select Guest Checkout
- Enter billing information using external test data
- Select country and state
- Continue through the billing section

## 🔧 Key Framework Features
### Reusable BasePage

BasePage provides reusable methods for common Selenium operations, including:

Click element
Enter text
Wait for element visibility
Retrieve text
Check whether an element is displayed
Retrieve the current value from an input field

The framework uses WebDriverWait and Selenium ExpectedConditions for synchronization rather than relying on fixed delays.

### Centralized Driver Management

DriverFactory is responsible for WebDriver creation and management.

A fresh browser instance is created for each test method through the BaseTest setup and teardown process.

### Configuration Management

Application configuration is maintained separately from the test implementation in:

src/main/resources/config.properties

ConfigReader loads the configured properties so application settings can be managed centrally.

### Test Data Management

Test data for checkout is maintained separately from the test implementation in:

`src/test/resources/testData.properties`

The `TestDataReader` utility loads the properties file and provides test data to the test classes using key-value pairs.

Example:

```properties
checkout.firstName=Test
checkout.lastName=User
checkout.email=testuser@example.com
checkout.telephone=3035550100
checkout.address=123 Test Street
checkout.city=Parker
checkout.postCode=80134
checkout.country=United States
checkout.state=Colorado
```

This approach reduces hardcoded test data in the test classes and makes test data easier to maintain.

### Data-Driven Testing

TestNG `@DataProvider` is used to execute the registration test with multiple sets of test data.

### Generalized Product Validation

Product search and selection are implemented using reusable product-name parameters rather than hardcoded product-specific locators.

This allows the same page methods to work with different products.


### Failure Screenshot Capture
The framework automatically captures a screenshot when a test fails.

The implementation uses Selenium's TakesScreenshot interface.

BaseTest uses TestNG's @AfterMethod to inspect the test result. When a test has a FAILURE status, it calls the reusable ScreenshotUtil.

The screenshot utility uses:

getScreenshotAs(OutputType.FILE)

to capture the screenshot, while Apache Commons IO is used to copy the captured file to the screenshot output directory.

This provides visual evidence that can assist with failure investigation and debugging.

## ▶️ Test Execution

The regression suite is configured in:

`testng.xml`

The suite includes:

- LoginTest
- RegisterTest
- SearchTest
- CartTest
- CheckoutTest

### Run with Maven

```bash
mvn test
```

The project can also be executed through the TestNG suite in Eclipse.

## 📊 Current Test Execution Result

The current regression suite has been executed successfully:

| Result | Count |
|---|---:|
| Total Tests | 9 |
| Passed | 9 |
| Failed | 0 |
| Skipped | 0 |

**Result: 9/9 tests passed ✅**

This result represents the current working state of the framework and regression suite.

## ⚙️ Configuration

Application configuration is maintained in:

`src/main/resources/config.properties`

Example:

browser=chrome
url=https://demo.opencartmarketplace.com/d2/demo_1/?demo=2

## 🎯 Framework Objectives

The framework was developed to demonstrate the following QA automation practices:

Build a maintainable Selenium automation framework
Apply Page Object Model principles
Reduce duplicated Selenium code through reusable methods
Centralize WebDriver management
Use explicit waits for synchronization
Separate configuration from test implementation
Automate both positive and negative scenarios
Capture screenshots for failed tests
Organize tests into a reusable TestNG regression suite


## Future Enhancements

Planned improvements include:

- API testing using Postman
- SQL/database validation
- CI/CD integration using GitHub Actions
- Enhanced test reporting
- Parallel test execution

## 👩‍💻 Author

Geeta Rane

QA Automation Test Engineer
Java | Selenium WebDriver | TestNG | Maven

## 📌 About This Project

This project was created to demonstrate practical QA automation and framework-development skills through an e-commerce testing workflow using the OpenCart demo application.
