package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_GetRequest {

    /*
     https://jsonplaceholder.typicode.com/posts/44 url'ine
     bir GET request yolladigimizda donen Response'in


         status code 200,
         content type JSON,
         response body'de bulunan userID 5,
         response body'de bulunan title "optio dolor molestias sit"
                                 oldugunu test edin.

     */
    @Test
    public void get01(){

        // 1- Request URL ve  Body olustur

        String url = "https://jsonplaceholder.typicode.com/posts/44 ";

        // 2- Expected Data olustur

        JSONObject expectedBody = new JSONObject();

        expectedBody.put("userId",5);
        expectedBody.put("title","optio dolor molestias sit");

       //  System.out.println(expectedBody); (Kullanmak Prof değil. Doğrulayıp silmek gerek.)

        // 3- Response kaydet

        Response response = given().when().get(url);

        // response.prettyPrint(); POSTMAN DE GORDUGUMUZUN AYNISINI GORURUZ.

        // 4- Assertion
         response.
                 then().
                 assertThat()
                 .statusCode(200).
                 contentType(ContentType.JSON);

         JsonPath actualBody = response.jsonPath();

        Assert.assertEquals(expectedBody.get("userId"),actualBody.get("userId"));
        Assert.assertEquals(expectedBody.get("title"),actualBody.get("title"));


    }
}
