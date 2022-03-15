package get_http_request_Questions;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest01 {

    // Rest-Assured kullanarak API Testing yapıyoruz

    @Test
    public void getMethod01(){

        given().
        when().
            get("https://restful-booker.herokuapp.com/booking").
        then().
            assertThat().
            statusCode(200);
    }


    // GET ile aldigim data'yi consol'da gormek isitiyorum

    @Test
    public void getMethod02(){

        Response response = given().
                            when().
                               get("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();
    }
}
