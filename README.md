## OrangeHRM Automation Testing (Selenium & Java)
This project is an automated testing framework built to verify the core functionalities of the OrangeHRM open-source platform. It demonstrates the application of modern automation practices, focusing on maintainability and scalability.

### Features
Module Automated: Login, Dashboard navigation, PIM (Employee Management).

Design Pattern: Implemented Page Object Model (POM) to separate test logic from UI elements.

Synchronization: Handled dynamic elements using Explicit and Implicit Waits.

Data Handling: Flexible locators using XPath and CSS Selectors.

Reporting: Integrated with Extent Reports / Allure Report (Tùy bạn chọn loại nào) for detailed test execution insights.
### Structure
orange-hrm-automation
├── src
│   ├── main
│   │   └── java
│   │       └── com.orangehrm
│   │           ├── pages       <-- Chứa các class Page Object (LoginPage, PIMPage)
│   │           ├── drivers     <-- Quản lý khởi tạo WebDriver
│   │           └── utils       <-- Các tiện ích (Đọc Excel, Config, Helpers)
│   └── test
│       ├── java
│       │   └── com.orangehrm
│       │       ├── tests       <-- Chứa các kịch bản test (LoginTest, AddUserTest)
│       │       └── base        <-- Chứa BaseTest (Setup/Teardown)
│       └── resources
│           ├── suites          <-- Nơi chứa các file XML như hình bạn đã gửi
│           ├── testdata        <-- Chứa file Excel, JSON dữ liệu đầu vào
│           └── config.properties <-- Chứa URL, Browser, Timeout
├── target                      <-- Nơi lưu kết quả biên dịch và báo cáo (Allure/Extent)
├── pom.xml                     <-- Quản lý dependencies (Selenium, TestNG)
└── README.md                   <-- Tài liệu hướng dẫn dự án
### Tech Stack
Language: Java (JDK 11+)

Automation Tool: Selenium WebDriver

Test Runner: TestNG

Build Tool: Maven

Reporting: Allure / Extent Reports

Version Control: Git


### Prerequisites
Java Development Kit (JDK) 11 or higher.

Apache Maven installed.

Chrome / Firefox browser.

### How to Run
Clone the repository:

Bash
git clone https://github.com/tranxuanbinhn/automation_orangehrmlive.git
Navigate to project folder:

Bash
cd automation_orangehrmlive
Run tests via Maven:

Bash
mvn clean test
### Reports
After execution, the test reports can be found in the target/ or test-output/ directory.

Author: Trần Xuân Bình
