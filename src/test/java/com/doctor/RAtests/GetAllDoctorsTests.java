package com.doctor.RAtests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class GetAllDoctorsTests extends TestBase {

    //POSITIVE
    @Test
    public void getAllDoctorsSuccessTest() {
        given()
                .header(AUTH, "Bearer " + accessToken)
                .when()
                .get("users/doctors/")
                .then()
                .assertThat().statusCode(200);

    }

    //NEGATIVE WITH WRONG ENDPOINT
    @Test
    public void getAllDoctorsNegativeTest() {
        given()
                .header(AUTH, "Bearer" + accessToken)
                .when()
                .get("users/Doc")
                .then()
                .assertThat().statusCode(403);
    }

}
