## Project Overview

This project automates the extraction and validation of upcoming bike details and used car models from the Zigwheels website. The automation script is developed using Selenium, TestNG, and Cucumber, with results captured in structured Excel reports.

## Problem Statement

### Identify New Bikes

**Objective:** Display details of upcoming bikes including bike name, price, and expected launch date in India with the following criteria:
1. Manufacturer should be Honda.
2. Bike price should be less than 4 Lakhs.

**Additional Objectives:**
1. Extract and display all popular used car models in Chennai.
2. Attempt to 'Login' with Google using invalid account details and capture the error message.

## Detailed Description

### Requirements:
1. Display details of "Upcoming" bikes (name, price, expected launch date) for Honda with prices less than 4 Lakhs.
2. For used cars in Chennai, extract and display a list of popular models.
3. Attempt to log in with Google using invalid details and capture the error message.

## Key Automation Scope

1. **Handling windows & frames:** Manage multiple windows and frames during the automation process.
2. **Filling simple forms and capturing warning messages:** Automate form filling and capture any warning messages encountered.
3. **Extracting menu items from frames and storing them in collections:** Extract data from various frames and store them for further processing.
4. **Navigating back to the home page:** Ensure smooth navigation across the website, including returning to the home page.

## Steps to Run the Project

1. **Configure the Browser:**
   - The default browser is Chrome. To change the browser, edit the number on line 66 of `ZigWheels.java`:
     - `1` for Mozilla Firefox
     - `2` for Google Chrome
     - `3` for Microsoft Edge

2. **Run TestNG.xml File:**
   - Load the Zigwheels homepage and redirect to a new Google Login window.
   - Log into the website using provided email-id and password (editable in `Zigwheels.xlsx` inside the `DataFiles` folder).
   - Navigate to the Upcoming Bikes page, select Honda as the manufacturer, and capture bike details with prices less than 4 Lakhs.
   - Store the bike details in sheet number 1 of `ExcelDetails.xlsx` inside the `ExcelOutput` folder.
   - Navigate to the Used Cars in Chennai page, apply the Rs. 5-10 Lakh filter, and store car names (sorted by brand) in sheet number 2 of `ExcelDetails.xlsx`.
   - Apply the Rs. 10-15 Lakh filter and store car names in sheet number 3 of `ExcelDetails.xlsx`.
   - Log extent reports and take screenshots throughout the process.
   - Close the browser after completing all test cases, with details printed in the Eclipse console.

## Prerequisites

- Java JDK
- Eclipse IDE
- Selenium WebDriver
- TestNG
- Cucumber
- Apache POI (for Excel handling)

## File Structure

- **src/main/java**: Contains the main Java files for automation.
- **src/test/java**: Contains the test cases.
- **DataFiles/Zigwheels.xlsx**: Contains login credentials and other data.
- **ExcelOutput/ExcelDetails.xlsx**: Stores the extracted bike and car details.
- **TestNG.xml**: The TestNG configuration file.

## Conclusion

This project demonstrates the automation of web data extraction and validation using Selenium, TestNG, and Cucumber, effectively handling browser interactions, data extraction, and error capturing with detailed reporting.
