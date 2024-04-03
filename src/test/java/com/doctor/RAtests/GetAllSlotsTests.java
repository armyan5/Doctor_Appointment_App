package com.doctor.RAtests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetAllSlotsTests extends TestBase {


    // USER
    // POSITIVE
    @Test
    public void getAllSlotsSuccessTest() {
        given()
                .header(AUTH, "Bearer " + accessToken)
                .when()
                .get("slots/")
                .then()
                .assertThat().statusCode(200);
    }


    // NEGATIVE
    // WITH WRONG ENDPOINT

    @Test
    public void getAllSlotsNegativeTest() {
        given()
                .header(AUTH, "Bearer " + accessToken)
                .when()
                .get("slots")
                .then()
                .assertThat().statusCode(404);
    }
}
