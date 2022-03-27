package get_http_request_Questions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest04 {

    /* POAITIVE SCENARIO :
         When I send a GET Request to
         https://dummy.restapiexample.com/api/v1/employees
         And Accept type "application/JSON"
         Then
         HTTP  Sattus Code should be 200
         And Response format should be "apllication/JSON"
         And there should be 24 employees
         And "Ashton Cox" should be one of the employees
         And 21, 61, and 63 should be among the employee ages
     */

    @Test
    public void get01(){
        Response response = given().
                               accept(ContentType.JSON). //"application/JSON" da kullanlabilir
                            when().
                               get("https://dummy.restapiexample.com/api/v1/employees");
             

               response.
                       then().
                       assertThat().
                       statusCode(200).
                       contentType(ContentType.JSON).//"application/JSON" da kullanlabilir
                       body("data.id",Matchers.hasSize(24)).
                       body("data.employee_name",Matchers.hasItem("Ashton Cox")).
                       body("data.employee_age",Matchers.hasItems("21,61,63"));

    }

}
