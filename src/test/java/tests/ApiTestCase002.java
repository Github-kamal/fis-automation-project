package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ApiTestCase002 {
    
	
    @Test
    public void testGBPDescription() {
        // Set Base URI from config
        RestAssured.baseURI = "https://api.coindesk.com/";
        
        // Perform GET Request
        Response response = RestAssured
                .given()
                .when()
                .get("v1/bpi/currentprice.json")
                .then()
                .statusCode(200)
                .extract()
                .response();
        
        // Extract GBP description
        String gbpDescription = response.jsonPath().getString("bpi.GBP.description");
        System.out.println("GBP Description: " + gbpDescription);
        
        // Assert GBP description
        Assert.assertEquals(gbpDescription, "British Pound Sterling", 
                "GBP description does not match the expected value!");
    }
}