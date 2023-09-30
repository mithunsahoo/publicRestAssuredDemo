package RestAssured.RestAssuredAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured.*;
import io.restassured.matcher.ResponseAwareMatcher;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import io.restassured.*;
public class AppTest {
    
  @Test
  public void test1() {
     Response response=RestAssured.get("https://reqres.in/api/users?page=2");
     System.out.println(response.getStatusCode());
     int statusCode= response.getStatusCode();
     Assert.assertEquals(statusCode,200);
  }
  
  
  @Test
  public void Test2() {
	 RestAssured.baseURI="https://reqres.in/api";
	 RestAssured.given().get("/users?page=2").then().statusCode(200).
	 body("data[1].id",equalTo(8)).
	 log().all();
	  
  }
}

