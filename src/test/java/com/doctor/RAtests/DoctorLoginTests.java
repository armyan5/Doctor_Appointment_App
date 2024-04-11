package com.doctor.RAtests;

import com.doctor.dto.LoginRequestDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class DoctorLoginTests extends TestBase {

    LoginRequestDto login = LoginRequestDto.builder()
            .username("smith@gm.com")
            .password("123S!fghjk")
            .build();


    //POSITIVE
    @Test
    public void loginSuccessTestDoctor() {
        String accessToken = given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(200)
                .body(containsString("accessToken"))
                .body(containsString("refreshToken"))
                .extract().path("refreshToken", "accessToken");

        System.out.println(accessToken + " ********** " + accessToken);

    }

    LoginRequestDto negativeLogin = LoginRequestDto.builder()
            .username("smith@gm")
            .password("123S!fghjk")
            .build();

    //NEGATIVE
    @Test
    public void loginNegativeTestWithWrongEMail() {
        given()
                .contentType(ContentType.JSON)
                .body(negativeLogin)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(403);
    }

    LoginRequestDto negativePassword = LoginRequestDto.builder()
            .username("smith@gm.com")
            .password("12fghjk")
            .build();

    @Test
    public void loginNegativeTestWithInvalidPassword() {
        given()
                .contentType(ContentType.JSON)
                .body(negativePassword)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(400);
    }

}
