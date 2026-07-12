# Task 1 - MBIO TESTNG -Selenium Framework
This is a TDD-style test automation framework for an mbio trading website, built using **Selenium WebDriver**, **TestNG**, and **Java**.

##  Features

- Test-Driven Development (TDD) with TestnG 
- Selenium WebDriver for browser automation  
- Data-driven testing using Excel sheets  
- Hybrid - Page Object Model (POM) and Component Object Model design patterns for maintainability. Reusable,common components eg: Navigation elements and related actions are created independently using COM concepts to increase readability and scalability. This helps to avoid duplication in each page objects.Non repeated full page eg: About US page is designed using POM concepts.
- Independent wait utils,config utils,data utils created to avoid large common utils single file.  
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

# Task 2 Doc 
Uploaded Task 2 Doc - includes the scenario based 5 answers , Test Plan, Risk Matrix and Release Readiness Checklists.

## Contact
Jyothi Lakshmi
Email: jyothilakshmisree04@gmail.com
