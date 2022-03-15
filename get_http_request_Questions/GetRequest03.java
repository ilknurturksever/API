package get_http_request_Questions;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest03 {

    /*
                  ***** POSITIVE SCENARIO *****

      When I send a GET request to REST API URL
      https://restful-booker.herokuapp.com/booking/1
      And Accept Type is "application/json"
      Then
      HTTP Status Code should be 200
      And response format should be "application/json"
      And first name should be "Susan"
      And last name should be "Brown"
      And checkin date should be "2015-02-16"
      And checkout date should be "2017-06-20"

     */

    @Test
    public void get01(){

        Response response = given().
                            accept("application/json").
                              get("https://restful-booker.herokuapp.com/booking/1");
        response.prettyPrint();

        // STATUS CODE ICIN 1. YOL:
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Susan")).
                body("lastname", Matchers.equalTo("Jones")).
                body("totalprice" , Matchers.equalTo(182)).
                body("depositpaid",Matchers.equalTo(true)).
                body("bookingdate.checkin",Matchers.equalTo("2019-09-18")).
                body("bookingdate.checkout",Matchers.equalTo("2015-03-12"));

        // TEKARALI BODY KULLANAMDAN NASIL YAPILIR ?

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Susan"),
                       "lastname", Matchers.equalTo("Jones"),
                       "totalprice" , Matchers.equalTo(182),
                       "depositpaid",Matchers.equalTo(true),
                       "bookingdate.checkin",Matchers.equalTo("2019-09-18"),
                       "bookingdate.checkout",Matchers.equalTo("2015-03-12"));

        // STATUS CODE ICIN 2. YOL:
        assertEquals(200,response.getStatusCode());
    }
}
