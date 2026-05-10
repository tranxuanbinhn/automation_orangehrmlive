OrangeHRM Automation Testing (Selenium & Java)
This project is an automated testing framework built to verify the core functionalities of the OrangeHRM open-source platform. It demonstrates the application of modern automation practices, focusing on maintainability and scalability.

Features
Module Automated: Login, Dashboard navigation, PIM (Employee Management).

Design Pattern: Implemented Page Object Model (POM) to separate test logic from UI elements.

Synchronization: Handled dynamic elements using Explicit and Implicit Waits.

Data Handling: Flexible locators using XPath and CSS Selectors.

Reporting: Integrated with Extent Reports / Allure Report (Tùy bạn chọn loại nào) for detailed test execution insights.

🛠 Tech Stack
Language: Java (JDK 11+)

Automation Tool: Selenium WebDriver

Test Runner: TestNG

Build Tool: Maven

Reporting: Allure / Extent Reports

Version Control: Git

Project Structure
Plaintext
src
├── main
│   └── java
│       └── pages           # Page Classes (Page Object Model)
├── test
│   └── java
│       └── tests           # Test Classes
├── resources
│   └── testng.xml          # Test Suite Configuration
└── pom.xml                 # Project Dependencies
Prerequisites
Java Development Kit (JDK) 11 or higher.

Apache Maven installed.

Chrome / Firefox browser.

How to Run
Clone the repository:

Bash
git clone https://github.com/tranxuanbinhn/automation_orangehrmlive.git
Navigate to project folder:

Bash
cd automation_orangehrmlive
Run tests via Maven:

Bash
mvn clean test
📊 Reports
After execution, the test reports can be found in the target/ or test-output/ directory.

Author: Trần Xuân Bình
