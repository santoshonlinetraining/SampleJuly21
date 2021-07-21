package programs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import scala.collection.mutable.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class Sample2WithPost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://216.10.245.166/";	
		//send request in POST method and validate the response with status code
		System.out.println("Ex:1 send request in POST method and validate the response with status code");
		
		String insName = "SantoshDCIT";
		
		given().
				header("Content-Type","application/json")
		.body("{\r\n" + 
				"	\"name\":\"Learn Selenium Automation with Java\",\r\n" + 
				"	\"isbn\":\""+insName+"\",\r\n" + 
				"	\"aisle\":\"1\",\r\n" + 
				"	\"author\":\"SantoshKumar\"\r\n" + 
				"}").
		when().
				post("Library/Addbook.php")
		.then().assertThat().statusCode(200);
		
		System.out.println("Book added successfully");
		
		
		
//		//send request in POST method and print the request jSon on LOG
//		System.out.println("Ex:2 send request in POST method and print the request jSon on LOG");
//		given().log().all().
//				header("Content-Type","application/json")
//		.body("{\r\n" + 
//				"	\"name\":\"Learn Selenium Automation with Java\",\r\n" + 
//				"	\"isbn\":\""+insName+"\",\r\n" + 
//				"	\"aisle\":\"2\",\r\n" + 
//				"	\"author\":\"SantoshKumar\"\r\n" + 
//				"}").
//		when().
//				post("Library/Addbook.php")
//		.then().assertThat().statusCode(200);

		
		
//		//send request in POST method and print the request & response in jSon LOG
//		System.out.println("Ex:3 send request in POST method and print the request & response in jSon LOG");
//		given().log().body().
//				header("Content-Type","application/json")
//		.body("{\r\n" + 
//				"	\"name\":\"Learn Selenium Automation with Java\",\r\n" + 
//				"	\"isbn\":\""+insName+"\",\r\n" + 
//				"	\"aisle\":\"3\",\r\n" + 
//				"	\"author\":\"SantoshKumar\"\r\n" + 
//				"}").
//		when().
//				post("Library/Addbook.php")
//		.then().log().body().assertThat().statusCode(200);

		
		
//		//Store the entire request and reponse in a string variable
//		System.out.println("Ex:4 Store the entire request and reponse in a string variable");
//		String response;
//		response = given().
//				header("Content-Type","application/json")
//		.body("{\r\n" + 
//				"	\"name\":\"Learn Selenium Automation with Java\",\r\n" + 
//				"	\"isbn\":\""+insName+"\",\r\n" + 
//				"	\"aisle\":\"4\",\r\n" + 
//				"	\"author\":\"SantoshKumar\"\r\n" + 
//				"}").
//		when().
//				post("Library/Addbook.php")
//		.then().extract().response().asString();
//		
//		System.out.println(response);

		
	
	
	}

}




