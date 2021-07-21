## Travel Automation
@author - Biswajit Sundara

### Application URL
https://blazedemo.com/

### Tools Used
* Selenium
* TestNG
* Json Path
* Extent Reports

### How to setup the project
* Clone the repository
* Input data is available here `travel-automation\data` 
* Browser drivers are mantained here `travel-automation\drivers` 
* Update the configuration in the property file `src\test\resources\GlobalSettings.properties` 
* Currently this is designed to work only for `Windows` platform


### How to Execute the tests
* Run `mvn clean test` and it will execute the test


### Viewing the Test Results
* Extent Report can be accessed here `travel-automation\Report.html`
* Sure fire report can be found here - `travel-automation\target\surefire-reports`


### Automated TestCase
* I have automated one happy path flow which lets the user to select from and to city and then book the flight.
* We need to validate the data flows correctly from one page to another (since this is demo app, data is static so couldn't validate)

### Possible Automated Scenarios
* Try to book flight to and from the same city and it shouldn't allow.
* Test the hyperlink 'destination of the week! The Beach!' works. As this is on home page, its critical
* Validate the arrival and departure time can't be same. (Possible only if the duration is 24 hours)
* Book the cheapest flight  (flight with minimum price)
* Book the earliest flight available (departure time is less)
* Book a flight that has minimum duration (calculate the duration between departure and the arrival)
* Based on which flight we select check the details on reservation page like flight number, price, Airlines
* Validate the total cost = Price + Arbitrary Fees and Taxes
* Check the purchase flight for all card types (Visa, American express, Dinner's club)
* Check we can't input any other value in the month field which is not between 01 to 12
* Similarly the year field shouldn't accept any year less than 2021
* Validate the amount, card number, expiration are same what's entered on the purchase page.
* Validate the booking id can't be null and the status should be successfull.
* Validate the date should be current date.