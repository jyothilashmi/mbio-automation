# MBIO TESTNG -Selenium Framework
This is a TDD-style test automation framework for an mbio trading website, built using **Selenium WebDriver**, **TestNG**, and **Java**.

##  Features

- Test-Driven Development (TDD) with TestnG 
- Selenium WebDriver for browser automation  
- Data-driven testing using Excel sheets  
- Hybrid - Page Object Model (POM) and Component Object Model design patterns for maintainability  
- Configurable environment setup  
- ExtentReports integration for rich HTML test reports
- Excel sheet support for data integration
- Configurable retry mechanism on failure
- Multiview port (Desktop & Mobile) integration
- Configurable separate testng xml for smoke and regression suite
- CI/CD Pipeline integration on commit (smoke suite) and schedule regression run (every day at 2AM GST).

---
## Tech Stack

- **Java** — Programming language  
- **Selenium WebDriver** — Browser automation  
- **TestNG** — TDD framework  
- **Maven** — Build automation and dependency management  
- **Apache POI** — Excel data-driven testing  
- **ExtentReports** — Rich HTML test reports  
- **Hybrid - Page Object Model (POM) and Component Object Model (COM)** — Design pattern for maintainable automation
- **Jenkins - CI/CD Pipeline** 
---

## Setup and Running Tests

### 1. Clone the repository

```bash
git clone https://github.com/jyothilashmi/mbio-automation.git
cd mbio-automation
```
### 2. Build the project and download dependencies
```bash
mvn clean install
```
### 3. Run tests using Maven and TestNG
```bash
mvn test
```
### 4. View Test Reports
ExtentReports HTML reports are generated in the reports/ directory.

## Contact
Jyothi Lakshmi
Email: jyothilakshmisree04@gmail.com
