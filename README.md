## 🛠️ Technologies & Tools

| Technology / Tool  | Purpose                                    |
| ------------------ | ------------------------------------------ |
| Java               | Programming language                       |
| Selenium WebDriver | Web UI automation                          |
| TestNG             | Test execution and assertions              |
| Maven              | Build and dependency management            |
| WebDriverManager   | WebDriver setup                            |
| Page Object Model  | Framework design pattern                   |
| Git & GitHub       | Version control and source-code management |
| Apache Commons IO  | Screenshot file handling                   |
# OpenCart Selenium Automation Framework

A **Selenium WebDriver automation framework built with Java, TestNG, and Maven** for automating key e-commerce workflows in the OpenCart demo application.

The framework follows the **Page Object Model (POM)** design pattern and focuses on reusable page actions, centralized WebDriver management, configuration management, explicit waits, organized test execution, and automatic failure screenshot capture.

## 📌 Project Overview

This project automates key OpenCart workflows, including:

* Login
* User Registration
* Product Search
* Invalid Product Search
* Add Product to Cart
* Shopping Cart Validation
* Guest Checkout and Billing Details

The framework is designed to demonstrate how a maintainable Selenium automation project can be structured using reusable components and separation of responsibilities.

---

## 🛠️ Technologies & Tools

| Technology / Tool  | Purpose                                    |
| ------------------ | ------------------------------------------ |
| Java               | Programming language                       |
| Selenium WebDriver | Web UI automation                          |
| TestNG             | Test execution and assertions              |
| Maven              | Build and dependency management            |
| WebDriverManager   | WebDriver setup                            |
| Page Object Model  | Framework design pattern                   |
| Git & GitHub       | Version control and source-code management |
| Apache Commons IO  | Screenshot file handling                   |

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
│   │   │       │
│   │   │       ├── core
│   │   │       │   └── DriverFactory.java
│   │   │       │
│   │   │       ├── pages
│   │   │       │   ├── HomePage.java
│   │   │       │   ├── LoginPage.java
│   │   │       │   ├── RegisterPage.java
│   │   │       │   ├── SearchPage.java
│   │   │       │   ├── ProductPage.java
│   │   │       │   ├── CartPage.java
│   │   │       │   └── CheckoutPage.java
│   │   │       │
│   │   │       └── utils
│   │   │           ├── ConfigReader.java
│   │   │           └── ScreenshotUtil.java
│   │   │
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       └── java
│           └── com.geeta.automation.opencart
│               ├── base
│               │   └── BaseTest.java
│               │
│               └── tests
│                   ├── LoginTest.java
│                   ├── RegisterTest.java
│                   ├── SearchTest.java
│                   ├── CartTest.java
│                   └── CheckoutTest.java
│
├── pom.xml
├── testng.xml
└── README.md
```

---

## 🧪 Automated Test Scenarios

### Login

* Navigate to the Login page
* Enter valid login credentials
* Submit login
* Verify successful login

### Registration

* Navigate to the Registration page
* Enter registration details
* Submit the registration form
* Validate the registration flow

### Product Search

* Search for a valid product
* Verify the product appears in the search results
* Search for an invalid product
* Verify the appropriate no-results message

### Shopping Cart
Shopping Cart
Search for a product
Open the product
Add the product to the cart
Navigate to the Shopping Cart
Verify the cart page
Verify the product
Verify quantity
Verify unit price
Guest Checkout
Add a product to the cart
Navigate to Checkout
Select Guest Checkout
Enter billing information
Select country and state
Continue through the billing section
🔧 Key Framework Features
Reusable BasePage

BasePage provides reusable methods for common Selenium operations, including:

Click element
Enter text
Wait for element visibility
Retrieve text
Check whether an element is displayed
Retrieve the current value from an input field

The framework uses WebDriverWait and Selenium ExpectedConditions for synchronization rather than relying on fixed delays.

Centralized Driver Management

DriverFactory is responsible for WebDriver creation and management.

A fresh browser instance is created for each test method through the BaseTest setup and teardown process.

Configuration Management

Application configuration is maintained separately from the test implementation in:

src/main/resources/config.properties

ConfigReader loads the configured properties so application settings can be managed centrally.

📸 Failure Screenshot Capture

The framework automatically captures a screenshot when a test fails.

The implementation uses Selenium's TakesScreenshot interface.

BaseTest uses TestNG's @AfterMethod to inspect the test result. When a test has a FAILURE status, it calls the reusable ScreenshotUtil.

The screenshot utility uses:

getScreenshotAs(OutputType.FILE)

to capture the screenshot, while Apache Commons IO is used to copy the captured file to the screenshot output directory.

This provides visual evidence that can assist with failure investigation and debugging.

▶️ Test Execution
Run the Regression Suite

The regression suite is configured in:

testng.xml

The suite includes:

LoginTest
RegisterTest
SearchTest
CartTest
CheckoutTest
Maven

Run the complete test suite with:

mvn test

The project can also be executed through the TestNG suite in Eclipse.

📊 Current Test Execution Result

The current regression suite has been executed successfully:

Total Tests Run: 10
Passed:          10
Failed:           0
Skipped:          0
✅ Current Result: 10/10 Tests Passed

This result represents the current working state of the framework and regression suite.

⚙️ Configuration

Application configuration is maintained in:

src/main/resources/config.properties

Example:

browser=chrome
url=https://demo.opencartmarketplace.com/d2/demo_1/?demo=2
🎯 Framework Objectives

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
🚀 Future Enhancements

Planned improvements include:

Data-driven testing
Generalized product and cart validations
API testing
SQL/database validation
CI/CD integration using GitHub Actions
Enhanced test reporting

These capabilities are planned enhancements and are not currently represented as implemented features of this repository.

👩‍💻 Author

Geeta Rane

QA Automation Test Engineer
Java | Selenium WebDriver | TestNG | Maven

📌 About This Project

This project was created to demonstrate practical QA automation and framework-development skills through an e-commerce testing workflow using the OpenCart demo application.
