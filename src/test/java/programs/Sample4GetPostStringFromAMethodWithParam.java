package programs;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;

public class Sample4GetPostStringFromAMethodWithParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get the request string from the method
		RestAssured.baseURI = "http://216.10.245.166/";	

		System.out.println("Get request from the method");
		JsonRequest obj = new JsonRequest();
		String response = given().log().all().
				header("Content-Type","application/json")
		.body(obj.addLibrary2("61")).
		when().
				post("Library/Addbook.php")
		.then().log().all().extract().response().asString();
		
		System.out.println(response);
	}

}
