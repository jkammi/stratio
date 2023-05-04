# Automated tests for the web page stratio.com
## :pushpin: Content:

- [Stack of technologies](#computer-stack-of-technologies)
- [Running tests](#running_woman-running-tests)
- [Build in Jenkins](#-build-in-jenkins)
- [Allure report example](#-allure-report-example)
- [Jira Integration](#-jira-integration)
- [Slack notifications](#-slack-notifications)
- [Telegram notifications](#-telegram-notifications)
- [Video of an example of running a test in Selenoid](#-video-example-selenoid)

## :computer: Stack of technologies

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Slack" src="images/logo/slack_logo.png">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Slack" src="images/logo/Jira_logo.png">
</p>

Autotests are written in <code>Java</code> using <code>JUnit 5</code> and <code>Gradle</code>.
For UI tests, the [Selenide] framework (https://selenide.org/) was used.
Tests can be run locally or using [Selenoid](https://aerokube.com/selenoid/).
Also implemented build in <code>Jenkins</code> with generation of Allure-report and sending notification with results to <code>Slack</code> or <code>Telegram</code> after completion of the run. All tests are linked with <code>Jira</code> issue's keys.

**Allure report includes:**

* Test execution steps (of automated and manual tests)
* Screenshot of the last step
* Page Source
* Browser console logs
* Video of run

## :running_woman: Running tests

### Running Tests Locally
```
gradle clean test -Denv=local
```

If necessary, you can override the launch options
```
gradle clean ${TASK}
-Denv=local
-Dbrowser_name=${BROWSER}
-Dbrowser_version=${BROWSERVERSION}
-Dscreen_resolution=${BROWSER_SIZE}
```

### Running tests on a remote browser
```
gradle clean test -Denv=remote
```
You can also override launch options if needed.

```
gradle clean ${TASK}
-Dremote_browser=${REMOTEBROWSER}
-Dbrowser_name=${BROWSER}
-Dbrowser_version=${BROWSERVERSION}
-Dscreen_resolution=${BROWSER_SIZE}

```

### Build options

* <code>TASK</code> it's the name of the task. The default is <code>test</code> to run all of them.
* <code>REMOTEBROWSER</code> is the address of the remote server where the tests will run.
* <code>BROWSER</code> is the browser in which the tests will be run. The default is <code>chrome</code>.
* <code>BROWSERVERSION</code> is the browser version in which the tests will be run. The default is <code>100.00</code>.
* <code>BROWSER_SIZE</code> is the size of the browser window in which tests will be run.

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Build in Jenkins
<p align="center">
<img title="Jenkins Build" src="images/screenshots/jenkinsBuild.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> Allure reports
### Overview

<p align="center">
<img title="Allure Overview" src="images/screenshots/allureReportMain.png">
</p>

### Test result

<p align="center">
<img title="Test Results in Alure" src="images/screenshots/allureReportTests.png">
</p>

Also we can connect <code>Jenkins</code> to the commercial version of <code>Allure</code>, which provides an opportunity to add there manual tests as well as an automated ones:

<p align="center">
<img title="Test Results in Alure" src="images/screenshots/allureReportAutoTestCases.png">
</p>

<p align="center">
<img title="Test Results in Alure" src="images/screenshots/allureReportManualTestCases.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira Integration" src="images/logo/Jira_logo.png"> Jira Integration

And also we can see from <code>Jira</code>, which tests been added to <code>Allure</code> with their statuses

<p align="center">
<img title="Allure Overview" src="images/screenshots/Jira_Integration_Example.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/slack_logo.png"> Slack notifications

<code>Slack</code> notification of test run
<p align="center">
<img width="50%" title="notification SlackExample.png" src="images/screenshots/notificationSlackExample.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Telegram notifications

<code>Telegram</code> notification of test run
<p align="center">
<img width="50%" title="Telegram Notifications" src="images/screenshots/notificationTelegramExample.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="images/logo/Selenoid.svg"> Video of an example of running a test in Selenoid

A video is attached to each test in the report. One of these videos is shown below.
<p align="center">
  <img title="Selenoid Video" src="images/gif/videoExample.gif">
</p>