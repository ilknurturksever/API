package get_http_request_Questions;

import TestBase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest06 extends TestBase {

    // TestBase class olusturup her testte kullanilan data'lari TestBase class'a koyup
    // tekrar tekrar ayni seyleri yazmaktan kurtulacagiz

    @Test
    public void get01(){

        Response response = given().spec(spec01).when().get();
    }
}
