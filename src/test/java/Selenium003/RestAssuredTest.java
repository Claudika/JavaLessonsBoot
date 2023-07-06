package Selenium003;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {
private WebDriver driver;
private Response response;
private RequestSpecification httpRequest;
@BeforeClass
    private void setUp(){
    WebDriverManager.chromedriver();
    driver = new ChromeDriver();
    driver.manage().window().minimize();

    RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
    httpRequest = given()
            .header("Authorization", "Bearer ddc039ffe9d09832fa53c7752cca9c36dbc5eb53c7eacaab20ee3de32495ba7d")
            .contentType(ContentType.JSON);
}
    @Test
    public void verifyStatusCode() {
        Response response = httpRequest.get("/users");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test (enabled = false)
    public void getUserTest() {
        response = given()
                .contentType(ContentType.JSON)
                .get("/users");

        // Verify the status code is 200
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        //Get the Response Body
        List<Map<String, Object>> users = response.jsonPath().getList("data");

        //Verify the response body contains the expected user details
        Assert.assertEquals(users.size(),10);


        String id = response.jsonPath().getString("[0].id");
        String name = response.jsonPath().getString("[0].name");
        String email = response.jsonPath().getString("[0].email");
        String Gender = response.jsonPath().getString("[0].gender");
        String Status = response.jsonPath().getString("[0].status");

        System.out.println(id + " "+ name +" "+ email+ " "+ Gender+ " "+ Status);
        //3291855 Msgr. Chandra Gill chandra_gill_msgr@feeney-price.test male active


        //Asserting the response of the first User
        Assert.assertEquals("3291855",id);
        Assert.assertEquals("Msgr. Chandra Gill",name);
        Assert.assertEquals("chandra_gill_msgr@feeney-price.test",email);
        Assert.assertEquals("male",Gender);
        Assert.assertEquals("active",Status);

    }
    @Test
    public void createUserTest() {
        // Set base URI and path
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        String endpoint = "/users";
        // Define request payload
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Hector Herrera");
        requestParams.put("email", "hectoherrera2003@example.com");
        requestParams.put("gender", "male");
        requestParams.put("status", "active");
        // Send POST request using RestAssured
        Response response = given()
                .header("Authorization", "Bearer ddc039ffe9d09832fa53c7752cca9c36dbc5eb53c7eacaab20ee3de32495ba7d") // Replace with the actual access token
                .contentType(ContentType.JSON)
                .body(requestParams.toString())
                .when()
                .post(endpoint);
        // Assert the response
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        // Retrieve the created user's ID from the response
      //   int userId = response.jsonPath().getInt("id");
        // Clean up: Delete the created user (optional)
//       given()
//                .header("Authorization", "Bearer ddc039ffe9d09832fa53c7752cca9c36dbc5eb53c7eacaab20ee3de32495ba7d") // Replace with the actual access token
//                .when()
//                .delete(endpoint + "/" + userId)
//                .then()
//                .statusCode(204);
    }@Test
    public void userPatch(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        String endpoint = "/users/";
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Carlos Herrera");

        Response response =given()
                .header("Authorization", "Bearer ddc039ffe9d09832fa53c7752cca9c36dbc5eb53c7eacaab20ee3de32495ba7d")
                .contentType(ContentType.JSON)
                .body(requestParams.toString())
                .when()
                .patch(endpoint);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
