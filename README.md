# Selenium-Cucumber-Framework

This is a sample framework containing single test case to test out the compose feature of Gmail. It uses the Page Object model to store the objects and business flows. Custom actions and verifications are implemented to handle exception and synchronization.

In order to execute it, run the below commands:
```
mvn clean install
```
Once it installs all the dependencies then run the below command
```
mvn test
```
Below HTML reports can be seen at target/cucumber folder.

![Screenshot](SampleReport.png)

**Future Scopes / Improvement**
- Add remaining test cases in automation for Compose feature
- Implement Extent Report / Allure along with its integration with Klov or any other report management tool
- Parameterized execution trigger for CI/CD
- Logging
