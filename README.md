# WP Dark Mood
 # Project Structure

This repository contains the following files and directories:

- `.github`: A directory that can contain GitHub-specific files, such as workflows.
- `.settings`: Configuration files for a development environment or IDE.
- `SaturnVPN_Config`: Configuration files or data related to SaturnVPN.
- `src`: The source code of the project. This is where the application's code is located.
- `target`: A directory where compiled code and build artifacts are typically stored.
- `test-output`: A directory that stores output from test runs or test reports.
- `.classpath`: A configuration file for the Eclipse IDE, specifying classpath settings.
- `.gitattributes`: A Git configuration file for specifying how certain files should be treated.
- `.project`: A configuration file for Eclipse projects.
- `README.md`: This file, provides an overview of the project structure.
- `chromedriver.exe`: The ChromeDriver executable for Selenium WebDriver.
- `operadriver.exe`: The OperaDriver executable for Selenium WebDriver.
- `pom.xml`: A Maven Project Object Model (POM) file that defines project dependencies, plugins, and configurations.
- `testng.xml`: A configuration file for TestNG, specifying test suite details.



WORKFLOW DESCRIPTION:

Unable to Access Demo WordPress Site for WP Dark Mode Automation Testing

Summary: 
While attempting to create and run an automation test script for WP Dark Mode on a demo WordPress site, several issues were encountered that prevented successful testing.

Steps:
•	Created a demo WordPress site for WP Dark Mode automation testing.
•	Attempted to run the test script using Google Chrome and Opera browsers.
•	Enabled VPN in both browsers to access the site.
•	Tried to complete the full automation script for testing.

Expected Result: 
The automation script should be able to execute all test scenarios successfully.

Actual Result:

Issue 1: Demo site does not support Chrome or Opera browsers.
Issue 2: Even with VPN enabled in both browsers, the site remains inaccessible.
Issue 3: Attempted to complete the full automation script, but encountered a roadblock on line 68 (commented as "// We need to upgrade to a Business Plan to install any kind of plugins and those are not for free").


Testing Strategy:

•	Browser Compatibility Testing
•	Browser Version Testing
•	Check Site Requirements
•	VPN Testing
•	Network Configuration Testing
•	Proxy Testing
•	Plan Restrictions Confirmation
•	Documentation 
•	Alternative Testing Environments


Severity: 
Medium (as test script is complete (but need to locate address with possible linkText)

Priority:
High (as it a blockage)
