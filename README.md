# gigaberlin

## Automation test regression suite for gigaberlin location 

### The below functionalities covered in testcases.

* Opens Goog home page
* Search for wikipedia
* enter giga berlin in search and click search
* gets the coordinates
* Opens a new tab and opens google maps home page
* Enters the coordinates in search box and click search button
* Close the browsers


### Tools and Technologies used

* Java
* TestNG
* Selenium
* Maven

### Configuration/setup to be done to run the project

* The below details are configured in config.properies file(available in gigaberlin\src\main\java\com\gigaberlin\config\config.properties)
	* baseURI for Google page
	* googleSearchString
	* wikiSearchString
	* googleMapsUrl
