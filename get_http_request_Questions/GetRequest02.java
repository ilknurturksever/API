package get_http_request_Questions;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetRequest02 {

    //                        ***** POSİTİVE SCENARIO *****
    // when() Bir get Request asagida verilen Endpoint'e yollanır
    // https://restful-booker.herokuapp.com/booking
    // and() Accept Type'i "application/json" dir.
    // then() ststus code 200'dur.
    // and() content type "application/json" dir.

    @Test
    public void get01(){

        given().
                accept("application/json"). // I'll work by use of JSON
        when().
                get("https://restful-booker.herokuapp.com/booking").
        then().
                assertThat().
                statusCode(200).
                contentType("application/json");
    }


    //                        ***** NEGATİVE SCENARIO *****
    // when() Bir get Request asagida verilen Endpoint'e yollanır
    // https://restful-booker.herokuapp.com/booking/1001
    // and() Accept Type'i "application/json" dir.
    // then() ststus code 404'dur.
    // and() content type "application/json" dir.

    @Test
    public void get02(){

       Response response = given().
                              accept("application/json").
                           when().
                               get("https://restful-booker.herokuapp.com/booking/1001");
       response.prettyPrint();
       response.
        then().
               assertThat().
               statusCode(404);
               // contentType("application/json");
    }


    //              ***** NEGATİVE SCENARIO *****
    // when() Bir get Request asagida verilen Endpoint'e yollanir
    // https://restful-booker.herokuapp.com/booking/1001
    // then() status code 404'dur
    // and() Response body'de "Not Found" var
    // and() Response body'de "Armut" yok

    @Test
    public void get03(){

        Response response = given().
                            when().
                               get("https://restful-booker.herokuapp.com/booking/1001");
        // Data'yi aldik ve Response'in icine depoladik
        
        response.prettyPrint(); // Gozumuzle gormek icin
        
        assertEquals(404,response.getStatusCode());
        assertTrue(response.asString().contains("Not Found")); // asString, response string'e ceviriyor ve contains ile esitliyor.
        assertFalse(response.asString().contains("Armut")); // Armut yok dicek










    }
}
