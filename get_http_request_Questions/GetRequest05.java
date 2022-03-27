package get_http_request_Questions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;


public class GetRequest05 {
    /*
       When I send a GET request to REST API URL
       https://restful-booker.herokuapp.com/booking/5
       Then HTTP Status Code should be 200
       And response content type is "application/JSON"
       And "firstname" should be "Jim",
       And "totalprice" should be 602,
       And "checkin" should be "2015-06-12"
     */

    @Test
    public void get01(){
        Response response = given().
                        when().
                get("https://restful-booker.herokuapp.com/booking/5");
        

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", Matchers.equalTo("Jim")).
                body("totalprice",Matchers.equalTo(509)).
                body("checkin",Matchers.equalTo("2015-09-28"));
    }
}
