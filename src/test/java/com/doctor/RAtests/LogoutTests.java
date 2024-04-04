package com.doctor.RAtests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogoutTests extends TestBase{

    @Test
    public void logoutTest() {
//        given()
//                .header(AUTH,"Bearer " + accessToken)
//                .when()
//                .get("auth/logout")                        BUG REPORT
//                .then()
//                .assertThat().statusCode(200);
    }
}
