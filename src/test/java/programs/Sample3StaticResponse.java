package programs;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class Sample3StaticResponse {
	JsonPath jp2;
	
	public static void main(String[] args) {
		
		JsonResponse obj = new JsonResponse();
		
		// TODO Auto-generated method stub
		System.out.println("========= Verify the Json complex Json response =========");
		JsonPath jp = new JsonPath(obj.responseOfCourseEnquire());
		
		//System.out.println(obj.responseOfCourseEnquire());
		
		//Get the size of Array
		//1. Print No of courses returned by API
		System.out.println("No of Courses are : " + jp.getInt("courses.size"));
		
		
		//2. Print Purchase Amount
		System.out.println("Print purchase amount : " + jp.getInt("dashboard.purchaseAmount"));

		
		//3. Print Title of the first course
		System.out.println("Print Title of the first course : " + jp.getString("courses[0].title"));
		
		
		//4. Print All course titles and their respective Prices
		System.out.println("Print All course titles and their respective Prices : " + jp.getString("courses[0].title"));
		
		for(int i=0; i<jp.getInt("courses.size"); i++){
			String courseName = jp.getString("courses["+i+"].title");
			System.out.println("Name of the course : "+courseName);
			
			int coursePrice = jp.getInt("courses["+i+"].price");
			System.out.println("price of the course is : " + coursePrice);
		}
		
		
		//5. Print no of copies sold by RPA Course
		for(int i=0; i<jp.getInt("courses.size"); i++){
			String courseName = jp.getString("courses["+i+"].title");
			int copies = jp.getInt("courses["+i+"].copies");
			
			if(courseName.equalsIgnoreCase("RPA")){
				System.out.println("Number of copies of RPA : " + copies);
				break;
			}
		}
		
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		int Total = 0;
		int purchaseAmount = jp.getInt("dashboard.purchaseAmount"); //1810
		
		for(int i=0; i<jp.getInt("courses.size"); i++) {
			Total = Total + (jp.getInt("courses["+i+"].price") * jp.getInt("courses["+i+"].copies"));
		} //2260
		
		System.out.println("Dashboard amount its " + purchaseAmount);
		System.out.println("Total amount is " + Total);
		
		if(purchaseAmount == Total) {
			System.out.println("DashBoardPurchase amount and Total amount of JSon both are matching: PASS");
		} else {
			System.out.println("DashBoardPurchase amount and Total amount of JSon both are NOT matching: FAIL");
		}
		
		Assert.assertEquals(Total, purchaseAmount);
		System.out.println("Sum of all Course prices matches with Purchase Amount is matching");
	}

}


