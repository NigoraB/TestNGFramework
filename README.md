Command to run regression.xml suite-file on Chrome browser
mvn clean test -DsuiteFile=SuiteFiles/regression.xml -DbrowserName="chrome"

Command to run regression.xml suite-file on Firefox browser
mvn clean test -DsuiteFile=SuiteFiles/regression.xml -DbrowserName="firefox"


Command to run testng.xml suite-file on Chrome browser
mvn clean test -DsuiteFile=SuiteFiles/testng.xml -DbrowserName="chrome"

Command to run testng.xml suite-file on Firefox browser
mvn clean test -DsuiteFile=SuiteFiles/testng.xml -DbrowserName="firefox"

SauceLabs/BrowserStack/Lambdatest


Explain your QA framework:
The current QA framework in a Maven project, designed using Page Object Model.
We write testcases in TestNG format using Test-annotations using Java programming language.
We have integrated allure-report in the framework to generate test report after test-execution.