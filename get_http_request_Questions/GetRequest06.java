package get_http_request_Questions;

import TestBase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest06 extends TestBase {

    // TestBase class olusturup her testte kullanilan data'lari TestBase class'a koyup
    // tekrar tekrar ayni seyleri yazmaktan kurtulacagiz

    /*
    When I send a GET request to REST API URL
    https://restful-booker.herokuapp.com/booking/5
    Then HTTP Status Code should be 200
    And response content type is "application/JSON"
    And response body should be like;
    {
         "firstname":  "Sally",
         "lastname" :  "Ericsson",
         "totalprice":  111,
         "depositpaid": false,
         "bookingdates": {
                 "checin": "2017-05-23",
                 "checout": "2019-07-02"
                 }
             */

    @Test
    public void get01(){

        Response response = given().
                             spec(spec01). // .com a kadar olan kismi kapsar yani base url
                            when().
                             get("/booking/5"); // .com dan sonrakileri buraya eklemek zorundayiz
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(404).
                contentType(ContentType.JSON);
    }
}
