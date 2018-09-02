<h2>Test app for smekalka.</h2>  
  
1. You need to create postgresql database with name `smekalka-dev`  
2. Database creates automaticaly when app is running  
3. Run application:`mvn spring-boot: run`  
4. App UI wil be available in `http://localhost:8080`   
5. You can change app properties in `application.properties` and `application-dev.properties`  
6. By default app running with dev profile  
  
  
Task:  
It is necessary to implement a web application that allows:    
1. Enter on the web form the data from the json file (it is in the application);  
2. Save data to the vault by clicking on the button on the form;  
3. Display the data stored in the vault on the form so that you can repeat step 1.  
4. Mandatory requirements: embedded micro container (jetty, tomcat), postgres, maven, spring.  
5. In addition to these, you can use those tools that you think are necessary for the correct execution of the task.  
  
App UI is optimised for work with only such JSON:
  
```  
{
	"tracks": [{
		"id": 1,
		"name": "Millbrook",
		"description": "Millbrook city course race track",
		"length": {
			"unit": "km",
			"value": 7.4
		},
		"cars": [{
			"id": "2",
			"code": "rdb1",
			"transmission": "automatic",
			"ai": "enabled",
			"max-speed": {
				"unit": "mps",
				"value": 110.12121212
			}
		}, {
			"id": "1",
			"code": "rdb3",
			"transmission": "automatic",
			"ai": "disabled",
			"max-speed": {
				"unit": "mps",
				"value": 120.967
			}
		}]
	}]
}
```