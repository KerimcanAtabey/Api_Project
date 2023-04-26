package Base;

import org.junit.Before;

import static io.restassured.RestAssured.baseURI;

public class BaseTest {



    @Before
    public void setup(){

        baseURI="https://www.omdbapi.com/";
    }
}
