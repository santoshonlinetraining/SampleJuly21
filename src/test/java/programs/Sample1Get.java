package programs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import scala.collection.mutable.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
//import org.testng.annotations.Test;

public class Sample1Get {
	
	/*@Test
	public void TestRESTAPI(){*/
	public static void main(String[] args) {
		RestAssured.baseURI = "https://postman-echo.com";
		
		//https://postman-echo.com/cookies/set?foo1=bar1&foo2=bar2
		// to validate the sttus
		given().
				param("foo1","bar1").
				param("foo2","bar2").
		when().
				get("/cookies/set").
		then().
				assertThat().statusCode(200);
		
		System.out.println("status code is 200 and PASS");


		
		// to validate the status and content type
		given().
				param("foo1","bar1").
				param("foo2","bar2").
		when().
				get("/cookies/set").
		then().
				assertThat().statusCode(200).and().contentType(ContentType.JSON);
		System.out.println("status code is 200 and Content type is Json");
		
		
		// To validate json body
		//Note: i changed the URI, below line is the example
		//http://dummy.restapiexample.com/api/v1/employees
		String empName = "Tiger Nixon";
		
		RestAssured.baseURI="http://dummy.restapiexample.com";
		
		given().
		when().
				get("/api/v1/employees").
		then().
			assertThat().statusCode(200).
			and().contentType(ContentType.JSON).
			and().body("data[0].employee_name",equalTo(empName));
		
		System.out.println("emp name is " + empName + " Emp Name validation is done successfully");
		
		
		//Verify the "Emp Name" and "Salary" from body.
		given().
		when().
		get("/api/v1/employees").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("data[0].employee_name",equalTo("Tiger Nixon")).
		body("data[0].employee_salary",equalTo(320800));
		System.out.println("verifying the emp Name and Salary is Done");
		
		
		//Validating the Response "Headers"
		RestAssured.baseURI="http://dummy.restapiexample.com";
		given().
		when().
		get("/api/v1/employees").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and();
		System.out.println("validating the headers is Done");
		
		/*
		/*
		//POST Method Examle below it wont work because copy pasted from WebSite
		HashMap<String,String> car = new HashMap<String, String>();
		car.put("plateNumber", "xyx1111");
		car.put("brand", "audi");
		car.put("colour", "red");

		given()
		.contentType("application/json")
		.body(car)
		.when().post("/garage/slots").then()
		.statusCode(200);
		
		System.out.println("test");
		
		/*
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); 
		requestParams.put("LastName", "Singh");

		requestParams.put("UserName", "simpleuser001");
		requestParams.put("Password", "password1");
		requestParams.put("Email",  "someuser@gmail.com");
		
		
*/	
	}
	
}
