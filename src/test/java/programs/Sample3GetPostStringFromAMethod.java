package programs;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;

public class Sample3GetPostStringFromAMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get the request string from the method
		
		JsonRequest obj = new JsonRequest();
		
		RestAssured.baseURI = "http://216.10.245.166/";	

//		System.out.println("Get request body from the method");
//		
//		//Send request without parameter
//		String response = given().log().all().
//				header("Content-Type","application/json")
//		.body(obj.addLibrary()).
//		when().
//				post("Library/Addbook.php")
//		.then().log().all().extract().response().asString();
//		
//		System.out.println(response);
		
		
		//Send request with parameter
		String response2 = given().log().all().
				header("Content-Type","application/json")
		.body(obj.addLibrary2("54")).
		when().
				post("Library/Addbook.php")
		.then().log().all().extract().response().asString();
		
		System.out.println(response2);
		
	}

}
