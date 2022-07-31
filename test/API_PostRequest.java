package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_PostRequest {
    @Test
    public void post01(){

        /*
        https://jsonplaceholder.typicode.com/posts URL'ine
        asagidaki body ile bir POST request gonderdigimizde

          "title" : "API",
          "body" : "API ogrenmek ne guzel",
          "userId" : 10,

          donen response'un,
          status code'unun 201,
          ve content type'nin application/json
          ve Response body'sinin id haric,

          "title" :"API",
          "body" : "API ogrenmek ne guzel",
          "userId": 10,
          oldugunu test edin.
         */

        // 1-Request URL ve body olustur

        String url ="https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();

        requestBody.put("title", "API");
        requestBody.put("body", "API ogrenmek ne guzel");
        requestBody.put("userId", 10);

        // 2- Expected Data olustur (eger acceptance criteria da verilirse test ederiz)

        JSONObject expectedBody = new JSONObject();

        expectedBody.put("title", "API");
        expectedBody.put("body", "API ogrenmek ne guzel");
        expectedBody.put("userId", 10);

        // 3- Response kaydet

        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(requestBody.toString()).
                post(url);

        JsonPath actBody = response.jsonPath();

        // 4- Assertion

        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(201);

        Assert.assertEquals(expectedBody.get("title"),actBody.get("title"));
        Assert.assertEquals(expectedBody.get("body"),actBody.get("body"));
        Assert.assertEquals(expectedBody.get("userId"),actBody.get("userId"));



    }
}
