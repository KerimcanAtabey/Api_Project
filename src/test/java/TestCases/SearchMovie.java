package TestCases;

import Base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SearchMovie extends BaseTest {


    @Test
  public void searchMovie(){

        Response response=given()
                .contentType(ContentType.JSON)
                .queryParam("t","The Batman")
                .queryParam("y","2022")
                .queryParam("apikey","a2639958")
                .when()
                .get()
                .then()
                .extract().response();

        response.then().log().body();
        Assert.assertEquals(200,response.statusCode());
        String idIMDB=response.jsonPath().getString("id");

        Response responseWithId=given()
                .contentType(ContentType.JSON)
                .queryParam("t","The Batman")
                .queryParam("i",idIMDB)
                .queryParam("apikey","a2639958")
                .when()
                .get()
                .then()
                .extract().response();

        response.then().log().body();
        Assert.assertEquals(200,response.statusCode());
        String reyting=response.jsonPath().getString("Rotten Tomatoes");
    }
}
