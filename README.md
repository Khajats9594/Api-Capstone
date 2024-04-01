# **Exchange Rate API Test Automation**
This project aims to automate the testing of an Exchange Rate API using Java and RestAssured library. It includes test cases to verify the functionality and performance of the API.

## Folder Structure:
    ├── pom.xml
    ├── src
    │   ├── main
    │   │   └── java
    │   │       ├── clients
    │   │       │   └── exchangeRateApi
    │   │       │       ├── ExchangeRateAssertionHelper.java
    │   │       │       └── ExchangeRateClient.java
    │   │       ├── constants
    │   │       │   └── FrameworkConstants.java
    │   │       ├── enums
    │   │       │   └── ConfigProperties.java
    │   │       ├── models
    │   │       │   └── ExchangeRateResponseBody.java
    │   │       └── utils
    │   │           ├── EndpointConfigReader.java
    │   │           └── PropertyUtils.java
    │   └── test
    │       ├── java
    │       │   └── testcases
    │       │       ├── BaseTest.java
    │       │       └── ExchangeRateTest.java
    │       └── resources
    │           ├── config.json
    │           └── config.properties


## Components:
1.  **ExchangeRateAssertionHelper:** Contains methods to assert various aspects of the API response such as success, status code, currency rates, response time, and currency pairs count.

2.  **ExchangeRateClient:** Handles the API call to fetch exchange rate data using RestAssured library.

3.  **FrameworkConstants:** Holds constant values like file paths for configuration files.

4.  **ConfigProperties:** Enumerates properties used within the project.

5.  **ExchangeRateResponseBody:** Represents the response body structure of the Exchange Rate API.

6.  **EndpointConfigReader:** Reads endpoint configurations from a JSON file.

7.  **PropertyUtils:** Reads properties from a configuration file.

8.  **BaseTest:** Sets up the base configuration for test execution using RestAssured.

9.  **ExchangeRateTest:** Contains test cases to validate the Exchange Rate API

## How to Run Tests:

1.  Ensure Java and Maven are installed on your system.
2.  Navigate to the project directory in the terminal.
3.  Run `mvn clean test` command to execute the test cases.

## Test Descriptions:

`testExchangeRateAPI`: Fetches exchange rate data from the API and asserts various aspects of the response including success, status code, currency rates, response time, and currency pairs count.

## Dependencies:

-   **RestAssured:** For API testing.
-   **TestNG:** For running test cases.


# Configuration:

-   Configuration properties are stored in `config.properties` file.
-   Endpoint configurations are stored in `config.json` file.